package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper.promiseWithError0

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

package object stream {
  type ErrorCallback = js.Function1[io.scalajs.nodejs.Error, Any]
  type Wait          = js.Function0[js.Promise[Unit]]

  implicit final class StreamModuleExtensions(private val stream: Stream.type) extends AnyVal {
    def pipelineFromSeq[D <: Stream](source: Stream,
                                     transforms: Seq[Stream],
                                     destination: D,
                                     errorCallback: ErrorCallback
    ): D = {
      transforms match {
        case Seq(a)          => stream.pipeline(source, a, destination, errorCallback)
        case Seq(a, b)       => stream.pipeline(source, a, b, destination, errorCallback)
        case Seq(a, b, c)    => stream.pipeline(source, a, b, c, destination, errorCallback)
        case Seq(a, b, c, d) => stream.pipeline(source, a, b, c, d, destination, errorCallback)
        case _ =>
          import scala.scalajs.js.JSConverters._
          val arguments: js.Array[js.Any] = transforms.toJSArray.asInstanceOf[js.Array[js.Any]]
          arguments.prepend(source)
          arguments.push(destination)
          arguments.push(errorCallback)
          stream.asInstanceOf[js.Dynamic].pipeline.apply(null, arguments).asInstanceOf[D]
      }
    }
  }

  implicit final class ReadableExtensions[R <: IReadable](private val readable: R) extends AnyVal {

    /** Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(listener: () => Any): R = readable.on("close", listener)

    /** Attaching a 'data' event listener to a stream that has not been explicitly paused will switch the stream into
      * flowing mode. Data will then be passed as soon as it is available.
      */
    @inline
    def onData[A](listener: A => Any): R = readable.on("data", listener)

    /** This event fires when there will be no more data to read. Note that the 'end' event will not fire unless the
      * data is completely consumed. This can be done by switching into flowing mode, or by calling stream.read()
      * repeatedly until you get to the end.
      */
    @inline
    def onEnd(listener: () => Any): R = readable.on("end", listener)

    /** Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(listener: Error => Any): R = readable.on("error", listener)

    /** When a chunk of data can be read from the stream, it will emit a 'readable' event. In some cases, listening for
      * a 'readable' event will cause some data to be read into the internal buffer from the underlying system, if it
      * hadn't already.
      */
    @inline
    def onReadable(listener: () => Any): R = readable.on("readable", listener)

    @inline def onPause(listener: () => Any): R  = readable.on("pause", listener)
    @inline def onResume(listener: () => Any): R = readable.on("resume", listener)

    @inline
    def iteratorAsString: scala.Iterator[String] =
      new scala.Iterator[String] {
        private var result: String = readable.readAsString()

        override def hasNext: Boolean = result != null

        override def next(): String = {
          val value = result
          result = readable.readAsString()
          value
        }
      }

    @inline
    def iteratorAsBuffer: scala.Iterator[Buffer] =
      new scala.Iterator[Buffer] {
        private var result: Buffer = readable.readAsBuffer()

        override def hasNext: Boolean = result != null

        override def next(): Buffer = {
          val value = result
          result = readable.readAsBuffer()
          value
        }
      }

    @inline
    def iteratorAsObject: scala.Iterator[js.Any] =
      new scala.Iterator[js.Any] {
        private var result: js.Any = readable.readAsObject()

        override def hasNext: Boolean = result != null

        override def next(): js.Any = {
          val value = result
          result = readable.readAsBuffer()
          value
        }
      }

    @inline
    def readAsObjectOption(): Option[js.Any] = Option(readable.readAsObject())

    @inline
    def readAsStringOption(): Option[String] = Option(readable.readAsString())

    @inline
    def readAsBufferOption(): Option[Buffer] = Option(readable.readAsBuffer())
  }
  implicit final class WritableExtensions[W <: IWritable](private val writable: W) extends AnyVal {

    /** Emitted when the stream and any of its underlying resources (a file descriptor, for example) have been closed.
      * The event indicates that no more events will be emitted, and no further computation will occur.
      */
    @inline
    def onClose(listener: () => Any): W = writable.on("close", listener)

    /** If a stream.write(chunk) call returns false, then the 'drain' event will indicate when it is appropriate to
      * begin writing more data to the stream.
      */
    @inline
    def onDrain(listener: () => Any): W = writable.on("drain", listener)

    /** Emitted if there was an error when writing or piping data.
      */
    @inline
    def onError(listener: Error => Any): W = writable.on("error", listener)

    /** When the stream.end() method has been called, and all data has been flushed to the underlying system, this event
      * is emitted.
      */
    @inline
    def onFinish(listener: () => Any): W = writable.on("finish", listener)

    /** This is emitted whenever the stream.pipe() method is called on a readable stream, adding this writable to its
      * set of destinations.
      */
    @inline
    def onPipe[R <: IReadable](listener: R => Any): W = writable.on("pipe", listener)

    /** This is emitted whenever the stream.unpipe() method is called on a readable stream, removing this writable from
      * its set of destinations.
      */
    @inline
    def onUnpipe[R <: IReadable](listener: R => Any): W = writable.on("unpipe", listener)

    @inline
    def endFuture(chunk: Buffer): Future[Unit] = promiseWithError0[Error](writable.end(chunk, _))

    @inline
    def endFuture(chunk: String, encoding: String): Future[Unit] = {
      promiseWithError0[Error](writable.end(chunk, encoding, _))
    }

    @inline
    def endFuture(chunk: String): Future[Unit] = {
      promiseWithError0[Error](writable.end(chunk, _))
    }

    @inline
    def endFuture(): Future[Unit] = promiseWithError0[Error](writable.end(_))

    @inline
    def writeFuture(chunk: Uint8Array): Future[Unit] = {
      promiseWithError0[Error](writable.write(chunk, _))
    }

    @inline
    def writeFuture(chunk: String, encoding: String): Future[Unit] = {
      promiseWithError0[Error](writable.write(chunk, encoding, _))
    }

    @inline
    def writeFuture(chunk: String): Future[Unit] = {
      promiseWithError0[Error](writable.write(chunk, _))
    }
  }

}
