package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * net package object
  */
package object net {
  type ConnectOptions = http.ConnectionOptions

  /**
    * net.Server Events
    * @param server the given [[Server server]]
    */
  implicit final class ServerExtensions[T <: Server](private val server: T) extends AnyVal {

    /**
      * Emitted when a new connection is made. socket is an instance of net.Socket.
      * @example server.on("close", function () { ... })
      */
    @inline def onClose(callback: () => Any): T = server.on("close", callback)

    /**
      * Emitted when a new connection is made. socket is an instance of net.Socket.
      */
    @inline def onConnection(callback: js.Function): T = server.on("connection", callback)

    /**
      * Emitted when an error occurs. The 'close' event will be called directly following this event.
      */
    @inline def onError(callback: Error => Any): T = server.on("error", callback)

    /**
      * Emitted when the server has been bound after calling server.listen.
      */
    @inline def onListening(callback: js.Function): T = server.on("listening", callback)
  }

  /**
    * net.Socket Extensions
    * @param socket the given [[Socket socket]]
    */
  implicit final class SocketExtensions[T <: Socket](private val socket: T) extends AnyVal {
    /////////////////////////////////////////////////////////////////////////////////
    //      Futures
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Opens the connection for a given socket.
      * @param path the connection path
      * @return a promise of an outcome
      */
    @inline def connectFuture(path: String): Future[Unit] = promiseCallback1[Unit](socket.connect(path, _))

    /**
      * Opens the connection for a given socket.
      * @param port the port number
      * @return a promise of an outcome
      */
    @inline def connectFuture(port: Int): Future[Unit] = promiseCallback1[Unit](socket.connect(port, _))

    /**
      * Opens the connection for a given socket.
      * @param port the port number
      * @param host the host name or IP
      * @return a promise of an outcome
      */
    @inline def connectFuture(port: Int, host: String): Future[Unit] = {
      promiseCallback1[Unit](socket.connect(port, host, _))
    }

    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Emitted once the socket is fully closed. The argument had_error is a boolean which says if the socket was
      * closed due to a transmission error.
      * @param callback - had_error <Boolean> true if the socket had a transmission error.
      * @example socket.on("close", function(had_error) { ... })
      */
    @inline def onClose(callback: Boolean => Any): T = socket.on("close", callback)

    /**
      * Emitted when a socket connection is successfully established. See connect().
      * @param callback the callback
      * @example socket.on("connect", function() { ... })
      */
    @inline def onConnect(callback: () => Any): T = socket.on("connect", callback)

    /**
      * Emitted when data is received. The argument data will be a Buffer or String. Encoding of data is set by
      * socket.setEncoding(). (See the Readable Stream section for more information.)
      *
      * Note that the data will be lost if there is no listener when a Socket emits a 'data' event.
      * @param callback - <Buffer>
      * @example socket.on("data", function(buffer) { ... })
      */
    @inline def onData(callback: Buffer | String => Any): T = socket.on("data", callback)

    /**
      * Emitted when the write buffer becomes empty. Can be used to throttle uploads.
      *
      * See also: the return values of socket.write()
      * @param callback the callback
      * @example socket.on("drain", function(???) { ... })
      */
    @inline def onDrain(callback: () => Any): T = socket.on("drain", callback)

    /**
      * Emitted when the other end of the socket sends a FIN packet.
      *
      * By default (allowHalfOpen == false) the socket will destroy its file descriptor once it has written out its
      * pending write queue. However, by setting allowHalfOpen == true the socket will not automatically end() its
      * side allowing the user to write arbitrary amounts of data, with the caveat that the user is required to end()
      * their side now.
      * @param callback the callback
      * @example socket.on("end", function(???) { ... })
      */
    @inline def onEnd(callback: () => Any): T = socket.on("end", callback)

    @inline def onError(callback: (Error) => Any): T = socket.on("error", callback)

    /**
      * Emitted after resolving the hostname but before connecting. Not applicable to UNIX sockets.
      * @param callback the callback, with the following arguments:
      *                 <ul>
      *                 <li>err <Error> | <Null> The error object. See dns.lookup().</li>
      *                 <li>address <String> The IP address.</li>
      *                 <li>family <String> | <Null> The address type. See dns.lookup().</li>
      *                 <li>host <String> The hostname.</li>
      *                 </ul>
      * @example socket.on("lookup", function(err, address, family, host) { ... })
      */
    @inline def onLookup(callback: (Error, String, String, String) => Any): T = socket.on("lookup", callback)

    @inline def onReady(callback: () => Any): T = socket.on("ready", callback)

    /**
      * Emitted if the socket times out from inactivity. This is only to notify that the socket has been idle. The user
      * must manually close the connection.
      *
      * See also: socket.setTimeout()
      * @param callback the callback
      * @example socket.on("timeout", function(???) { ... })
      */
    @inline def onTimeout(callback: js.Function): T = socket.on("timeout", callback)
  }
}
