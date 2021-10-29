package io.scalajs.nodejs
package stream

import com.thoughtworks.enableIf
import _root_.net.exoego.scalajs.types.util.Factory

import scala.scalajs.js.|
import io.scalajs.nodejs.buffer.{Blob, Buffer}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}
import scala.scalajs.js.typedarray.{ArrayBuffer, Uint8Array}

/** Marker trait as parent of both Readable and Writable.
  */
@js.native
trait Stream extends js.Object

@js.native
@JSImport("stream", JSImport.Namespace)
object Stream extends js.Object {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  def addAbortSignal[T <: Stream](signal: AbortSignal, stream: T): T = js.native

  def finished(stream: Stream, options: FinishedOptions, callback: ErrorCallback): Wait = js.native
  def finished(stream: Stream, callback: ErrorCallback): Wait                           = js.native

  def pipeline[D <: Stream](source: Stream, destination: D, callback: ErrorCallback): D            = js.native
  def pipeline[D <: Stream](source: Stream, a: Stream, destination: D, callback: ErrorCallback): D = js.native
  def pipeline[D <: Stream](source: Stream, a: Stream, b: Stream, destination: D, callback: ErrorCallback): D =
    js.native
  def pipeline[D <: Stream](source: Stream,
                            a: Stream,
                            b: Stream,
                            c: Stream,
                            destination: D,
                            callback: ErrorCallback
  ): D = js.native
  def pipeline[D <: Stream](source: Stream,
                            a: Stream,
                            b: Stream,
                            c: Stream,
                            d: Stream,
                            destination: D,
                            callback: ErrorCallback
  ): D = js.native
}

/** Custom Readable streams must call the new stream.Readable([options]) constructor and implement the readable._read()
  * method. https://nodejs.org/api/stream.html#stream_implementing_a_readable_stream
  */
@js.native
@JSImport("stream", "Readable")
class Readable() extends IReadable {
  def this(options: ReadableOptions) = this()

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def readableAborted: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def readableDidRead: Boolean = js.native
}

@js.native
@JSImport("stream", "Readable")
object Readable extends js.Object {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def from(iterable: js.Iterable[_],
                                                                              options: ReadableOptions
  ): Readable = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def from(iterable: js.Iterable[_]): Readable =
    js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def isDistributed(stream: Readable): Boolean = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def isDistributed(stream: IReadable): Boolean = js.native
}

/** Custom Writable streams must call the new stream.Writable([options]) constructor and pass the writable._write()
  * and/or writable._writev() method implementations via options.
  * https://nodejs.org/api/stream.html#stream_implementing_a_writable_stream
  */
@js.native
@JSImport("stream", "Writable")
class Writable() extends IWritable {
  def this(options: WritableOptions) = this()
}

/** A "duplex" stream is one that is both Readable and Writable, such as a TCP socket connection. <p/><b>Note</b> that
  * stream.Duplex is an abstract class designed to be extended with an underlying implementation of the
  * stream._read(size) and stream._write(chunk, encoding, callback) methods as you would with a Readable or Writable
  * stream class.
  *
  * Since JavaScript doesn't have multiple prototypal inheritance, this class prototypally inherits from Readable, and
  * then parasitically from Writable. It is thus up to the user to implement both the low-level stream._read(n) method
  * as well as the low-level stream._write(chunk, encoding, callback) method on extension duplex classes.
  */
@js.native
@JSImport("stream", "Duplex")
class Duplex() extends IDuplex {
  def this(options: DuplexOptions) = this()
}

@js.native
@JSImport("stream", "Duplex")
object Duplex extends js.Object {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: Stream): Duplex = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: Blob): Duplex = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: ArrayBuffer): Duplex = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: String): Duplex = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: js.Iterable[js.Any]): Duplex = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs16)
  def from(src: js.Promise[js.Any]): Duplex = js.native
  // TODO* AsyncIterable<any> | AsyncGeneratorFunction
}

/** Transform streams are Duplex streams where the output is in some way computed from the input. They implement both
  * the Readable and Writable interfaces.
  */
@js.native
@JSImport("stream", "Transform")
class Transform() extends ITransform {
  def this(options: TransformOptions) = this()
}

/** This is a trivial implementation of a Transform stream that simply passes the input bytes across to the output. Its
  * purpose is mainly for examples and testing, but there are occasionally use cases where it can come in handy as a
  * building block for novel sorts of streams.
  */
@js.native
@JSImport("stream", "PassThrough")
class PassThrough() extends Transform

/** The Readable stream interface is the abstraction for a source of data that you are reading from. In other words,
  * data comes out of a Readable stream.
  * @see
  *   https://nodejs.org/api/stream.html#stream_readable_streams
  */
@js.native
sealed trait IReadable extends Stream with LegacyStream {
  def destroyed: Boolean = js.native

  /** This method returns whether or not the readable has been explicitly paused by client code (using stream.pause()
    * without a corresponding stream.resume()).
    * @example
    *   readable.isPaused()
    */
  def isPaused(): Boolean = js.native

  /** This method will cause a stream in flowing mode to stop emitting 'data' events, switching out of flowing mode. Any
    * data that becomes available will remain in the internal buffer.
    * @example
    *   readable.pause()
    */
  def pause(): this.type = js.native

  /** This method pulls all the data out of a readable stream, and writes it to the supplied destination, automatically
    * managing the flow so that the destination is not overwhelmed by a fast readable stream. Multiple destinations can
    * be piped to safely.
    * @example
    *   readable.pipe(destination[, options])
    */
  def pipe(destination: IWritable, options: ReadablePipeOptions): this.type = js.native
  def pipe(destination: IWritable): this.type                               = js.native

  /** When chunk is a Buffer or string, the chunk of data will be added to the internal queue for users of the stream to
    * consume. Passing chunk as null signals the end of the stream (EOF), after which no more data can be written.
    *
    * When the Readable is operating in paused mode, the data added with readable.push() can be read out by calling the
    * readable.read() method when the 'readable' event is emitted.
    *
    * When the Readable is operating in flowing mode, the data added with readable.push() will be delivered by emitting
    * a 'data' event.
    * @param chunk
    *   the chunk of data to push into the read queue
    * @param encoding
    *   the encoding of String chunks. Must be a valid Buffer encoding, such as 'utf8' or 'ascii'
    * @return
    *   true if additional chunks of data may continued to be pushed; false otherwise.
    */
  def push(chunk: String, encoding: String): Boolean = js.native
  def push(chunk: String): Boolean                   = js.native

  /** When chunk is a Buffer or string, the chunk of data will be added to the internal queue for users of the stream to
    * consume. Passing chunk as null signals the end of the stream (EOF), after which no more data can be written.
    *
    * When the Readable is operating in paused mode, the data added with readable.push() can be read out by calling the
    * readable.read() method when the 'readable' event is emitted.
    *
    * When the Readable is operating in flowing mode, the data added with readable.push() will be delivered by emitting
    * a 'data' event.
    * @param chunk
    *   the chunk of data to push into the read queue
    * @return
    *   true if additional chunks of data may continued to be pushed; false otherwise.
    */
  def push(chunk: Uint8Array): Boolean = js.native

  @JSName("read") def readAsString(size: Int): String = js.native
  @JSName("read") def readAsString(): String          = js.native
  @JSName("read") def readAsBuffer(size: Int): Buffer = js.native
  @JSName("read") def readAsBuffer(): Buffer          = js.native
  @JSName("read") def readAsObject(size: Int): js.Any = js.native
  @JSName("read") def readAsObject(): js.Any          = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def readable: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def readableEncoding: String = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def readableEnded: Boolean = js.native

  def readableFlowing: Boolean | Null = js.native

  def readableHighWaterMark: Double = js.native

  def readableLength: Int = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def readableObjectMode: Boolean = js.native

  /** This method will cause the readable stream to resume emitting 'data' events. This method will switch the stream
    * into flowing mode. If you do not want to consume the data from a stream, but you do want to get to its 'end'
    * event, you can call stream.resume() to open the flow of data.
    * @example
    *   readable.resume()
    */
  def resume(): this.type = js.native

  /** Call this function to cause the stream to return strings of the specified encoding instead of Buffer objects. For
    * example, if you do readable.setEncoding('utf8'), then the output data will be interpreted as UTF-8 data, and
    * returned as strings. If you do readable.setEncoding('hex'), then the data will be encoded in hexadecimal string
    * format. <p/>This properly handles multi-byte characters that would otherwise be potentially mangled if you simply
    * pulled the Buffers directly and called buf.toString(encoding) on them. If you want to read the data as strings,
    * always use this method. <p/>Also you can disable any encoding at all with readable.setEncoding(null). This
    * approach is very useful if you deal with binary data or with large multi-byte strings spread out over multiple
    * chunks.
    * @example
    *   readable.setEncoding(encoding)
    */
  def setEncoding(encoding: String): this.type = js.native

  /** This method will remove the hooks set up for a previous stream.pipe() call. <p/>If the destination is not
    * specified, then all pipes are removed. <p/>If the destination is specified, but no pipe is set up for it, then
    * this is a no-op.
    * @example
    *   readable.unpipe([destination])
    */
  def unpipe(destination: IWritable): Unit = js.native
  def unpipe(): Unit                       = js.native

  /** This is useful in certain cases where a stream is being consumed by a parser, which needs to "un-consume" some
    * data that it has optimistically pulled out of the source, so that the stream can be passed on to some other party.
    * <p/><b>Note</b> that stream.unshift(chunk) cannot be called after the 'end' event has been triggered; a runtime
    * error will be raised. <p>If you find that you must often call stream.unshift(chunk) in your programs, consider
    * implementing a Transform stream instead.
    * @example
    *   readable.unshift(chunk)
    */
  def unshift(chunk: String): Unit     = js.native
  def unshift(chunk: Uint8Array): Unit = js.native

  /** Versions of Node.js prior to v0.10 had streams that did not implement the entire Streams API as it is today. (See
    * Compatibility for more information.) <p/>If you are using an older Node.js library that emits 'data' events and
    * has a stream.pause() method that is advisory only, then you can use the wrap() method to create a Readable stream
    * that uses the old stream as its data source. <p/>You will very rarely ever need to call this function, but it
    * exists as a convenience for interacting with old Node.js programs and libraries.
    * @example
    *   readable.wrap(stream)
    */
  def wrap(stream: LegacyStream): Unit = js.native
}

@Factory
trait ReadableOptions extends js.Object {
  var highWaterMark: js.UndefOr[Int]   = js.undefined
  var encoding: js.UndefOr[String]     = js.undefined
  var objectMode: js.UndefOr[Boolean]  = js.undefined
  var emitClose: js.UndefOr[Boolean]   = js.undefined
  var read: js.UndefOr[js.Function]    = js.undefined
  var destroy: js.UndefOr[js.Function] = js.undefined
  var autoDestroy: js.UndefOr[Boolean] = js.undefined
}

@Factory
trait ReadablePipeOptions extends js.Object {

  /** End the writer when the reader ends. Defaults to true.
    */
  var end: js.UndefOr[Boolean] = js.undefined
}

/** Readable State
  */
@js.native
trait ReadableState extends js.Object {
  var flowing: java.lang.Boolean = js.native
}

/** The Writable stream interface is an abstraction for a destination that you are writing data to.
  */
@js.native
sealed trait IWritable extends Stream with LegacyStream {
  // ///////////////////////////////////////////////////////////////////////////////
  //      Methods
  // ///////////////////////////////////////////////////////////////////////////////

  /** Forces buffering of all writes. Buffered data will be flushed either at stream.uncork() or at stream.end() call.
    * @example
    *   writable.cork()
    */
  def cork(): Unit = js.native

  def destroy(error: io.scalajs.nodejs.Error): Unit = js.native
  def destroy(): Unit                               = js.native

  def destroyed: Boolean = js.native

  def end(chunk: String, callback: js.Function1[Error, Any]): this.type                   = js.native
  def end(chunk: Uint8Array, callback: js.Function1[Error, Any]): this.type               = js.native
  def end(chunk: String): this.type                                                       = js.native
  def end(chunk: Uint8Array): this.type                                                   = js.native
  def end(chunk: String, encoding: String, callback: js.Function1[Error, Any]): this.type = js.native
  def end(chunk: String, encoding: String): this.type                                     = js.native
  def end(callback: js.Function1[Error, Any]): this.type                                  = js.native
  def end(): this.type                                                                    = js.native

  /** Sets the default encoding for a writable stream.
    * @example
    *   writable.setDefaultEncoding(encoding)
    */
  def setDefaultEncoding(encoding: String): this.type = js.native

  /** Flush all data, buffered since stream.cork() call.
    * @example
    *   writable.uncork()
    */
  def uncork(): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writable: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableEnded: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableCorked: Int = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableFinished: Boolean = js.native

  def writableHighWaterMark: Double = js.native

  def writableLength: Int = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableObjectMode: Boolean = js.native

  def write(chunk: Uint8Array, callback: js.Function1[Error, Any]): Boolean               = js.native
  def write(chunk: Uint8Array): Boolean                                                   = js.native
  def write(chunk: String, callback: js.Function1[Error, Any]): Boolean                   = js.native
  def write(chunk: String): Boolean                                                       = js.native
  def write(chunk: String, encoding: String): Boolean                                     = js.native
  def write(chunk: String, encoding: String, callback: js.Function1[Error, Any]): Boolean = js.native
}

@Factory
trait WritableOptions extends js.Object {
  var highWaterMark: js.UndefOr[Int]      = js.undefined
  var decodeStrings: js.UndefOr[Boolean]  = js.undefined
  var defaultEncoding: js.UndefOr[String] = js.undefined
  var objectMode: js.UndefOr[Boolean]     = js.undefined
  var emitClose: js.UndefOr[Boolean]      = js.undefined
  var write: js.UndefOr[js.Function]      = js.undefined
  var writev: js.UndefOr[js.Function]     = js.undefined
  var destroy: js.UndefOr[js.Function]    = js.undefined
  var `final`: js.UndefOr[js.Function]    = js.undefined
  var autoDestroy: js.UndefOr[Boolean]    = js.undefined
}

/** Duplex Interface
  */
@js.native
sealed trait IDuplex extends IReadable with IWritable {
  override def destroyed: Boolean = js.native
}

@js.native
sealed trait ITransform extends IDuplex

@Factory
trait DuplexOptions extends js.Object {

  /** If set to false, then the stream will automatically end the readable side when the writable side ends and vice
    * versa (Default: true).
    */
  var allowHalfOpen: js.UndefOr[Boolean] = js.undefined

  /** Sets objectMode for readable side of the stream. Has no effect if objectMode is true (Default: false).
    */
  var readableObjectMode: js.UndefOr[Boolean] = js.undefined

  /** Sets objectMode for writable side of the stream. Has no effect if objectMode is true (Default: false).
    */
  var writableObjectMode: js.UndefOr[Boolean] = js.undefined
}

@Factory
trait TransformOptions extends js.Object {
  var transform: js.UndefOr[js.Function] = js.undefined
  var flush: js.UndefOr[js.Function]     = js.undefined
}
