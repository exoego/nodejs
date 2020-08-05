package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * System Error
  */
@js.native
trait SystemError extends Error {

  /**
    * The error.errno property is a number or a string. The number is a negative value which corresponds
    * to the error code defined in libuv Error handling. See uv-errno.h header file (deps/uv/include/uv-errno.h
    * in the Node.js source tree) for details. In case of a string, it is the same as error.code.
    */
  val errno: String | Int = js.native

  /**
    * The error.syscall property is a string describing the syscall that failed.
    */
  val syscall: String = js.native

  /**
    * When present (e.g. in fs or child_process), the error.path property is a string containing
    * a relevant invalid pathname.
    */
  val path: String = js.native

  /**
    * When present (e.g. in net or dgram), the error.address property is a string describing the address
    * to which the connection failed.
    */
  val address: String = js.native

  /**
    * When present (e.g. in net or dgram), the error.port property is a number representing the connection's
    * port that is not available.
    */
  val port: Int = js.native

  val dest: String    = js.native
  val info: js.Object = js.native
}

object SystemErrorCodes {
  final val E2BIG           = "E2BIG"
  final val EACCES          = "EACCES"
  final val EADDRINUSE      = "EADDRINUSE"
  final val EADDRNOTAVAIL   = "EADDRNOTAVAIL"
  final val EAFNOSUPPORT    = "EAFNOSUPPORT"
  final val EAGAIN          = "EAGAIN"
  final val EALREADY        = "EALREADY"
  final val EBADE           = "EBADE"
  final val EBADF           = "EBADF"
  final val EBADFD          = "EBADFD"
  final val EBADMSG         = "EBADMSG"
  final val EBADR           = "EBADR"
  final val EBADRQC         = "EBADRQC"
  final val EBADSLT         = "EBADSLT"
  final val EBUSY           = "EBUSY"
  final val ECANCELED       = "ECANCELED"
  final val ECHILD          = "ECHILD"
  final val ECHRNG          = "ECHRNG"
  final val ECOMM           = "ECOMM"
  final val ECONNABORTED    = "ECONNABORTED"
  final val ECONNREFUSED    = "ECONNREFUSED"
  final val ECONNRESET      = "ECONNRESET"
  final val EDEADLK         = "EDEADLK"
  final val EDEADLOCK       = "EDEADLOCK"
  final val EDESTADDRREQ    = "EDESTADDRREQ"
  final val EDOM            = "EDOM"
  final val EDQUOT          = "EDQUOT"
  final val EEXIST          = "EEXIST"
  final val EFAULT          = "EFAULT"
  final val EFBIG           = "EFBIG"
  final val EHOSTDOWN       = "EHOSTDOWN"
  final val EHOSTUNREACH    = "EHOSTUNREACH"
  final val EHWPOISON       = "EHWPOISON"
  final val EIDRM           = "EIDRM"
  final val EILSEQ          = "EILSEQ"
  final val EINPROGRESS     = "EINPROGRESS"
  final val EINTR           = "EINTR"
  final val EINVAL          = "EINVAL"
  final val EIO             = "EIO"
  final val EISCONN         = "EISCONN"
  final val EISDIR          = "EISDIR"
  final val EISNAM          = "EISNAM"
  final val EKEYEXPIRED     = "EKEYEXPIRED"
  final val EKEYREJECTED    = "EKEYREJECTED"
  final val EKEYREVOKED     = "EKEYREVOKED"
  final val EL2HLT          = "EL2HLT"
  final val EL2NSYNC        = "EL2NSYNC"
  final val EL3HLT          = "EL3HLT"
  final val EL3RST          = "EL3RST"
  final val ELIBACC         = "ELIBACC"
  final val ELIBBAD         = "ELIBBAD"
  final val ELIBEXEC        = "ELIBEXEC"
  final val ELIBMAX         = "ELIBMAX"
  final val ELIBSCN         = "ELIBSCN"
  final val ELNRANGE        = "ELNRANGE"
  final val ELOOP           = "ELOOP"
  final val EMEDIUMTYPE     = "EMEDIUMTYPE"
  final val EMFILE          = "EMFILE"
  final val EMLINK          = "EMLINK"
  final val EMSGSIZE        = "EMSGSIZE"
  final val EMULTIHOP       = "EMULTIHOP"
  final val ENAMETOOLONG    = "ENAMETOOLONG"
  final val ENETDOWN        = "ENETDOWN"
  final val ENETRESET       = "ENETRESET"
  final val ENETUNREACH     = "ENETUNREACH"
  final val ENFILE          = "ENFILE"
  final val ENOANO          = "ENOANO"
  final val ENOBUFS         = "ENOBUFS"
  final val ENODATA         = "ENODATA"
  final val ENODEV          = "ENODEV"
  final val ENOENT          = "ENOENT"
  final val ENOEXEC         = "ENOEXEC"
  final val ENOKEY          = "ENOKEY"
  final val ENOLCK          = "ENOLCK"
  final val ENOLINK         = "ENOLINK"
  final val ENOMEDIUM       = "ENOMEDIUM"
  final val ENOMEM          = "ENOMEM"
  final val ENOMSG          = "ENOMSG"
  final val ENONET          = "ENONET"
  final val ENOPKG          = "ENOPKG"
  final val ENOPROTOOPT     = "ENOPROTOOPT"
  final val ENOSPC          = "ENOSPC"
  final val ENOSR           = "ENOSR"
  final val ENOSTR          = "ENOSTR"
  final val ENOSYS          = "ENOSYS"
  final val ENOTBLK         = "ENOTBLK"
  final val ENOTCONN        = "ENOTCONN"
  final val ENOTDIR         = "ENOTDIR"
  final val ENOTEMPTY       = "ENOTEMPTY"
  final val ENOTRECOVERABLE = "ENOTRECOVERABLE"
  final val ENOTSOCK        = "ENOTSOCK"
  final val ENOTSUP         = "ENOTSUP"
  final val ENOTTY          = "ENOTTY"
  final val ENOTUNIQ        = "ENOTUNIQ"
  final val ENXIO           = "ENXIO"
  final val EOPNOTSUPP      = "EOPNOTSUPP"
  final val EOVERFLOW       = "EOVERFLOW"
  final val EOWNERDEAD      = "EOWNERDEAD"
  final val EPERM           = "EPERM"
  final val EPFNOSUPPORT    = "EPFNOSUPPORT"
  final val EPIPE           = "EPIPE"
  final val EPROTO          = "EPROTO"
  final val EPROTONOSUPPORT = "EPROTONOSUPPORT"
  final val EPROTOTYPE      = "EPROTOTYPE"
  final val ERANGE          = "ERANGE"
  final val EREMCHG         = "EREMCHG"
  final val EREMOTE         = "EREMOTE"
  final val EREMOTEIO       = "EREMOTEIO"
  final val ERESTART        = "ERESTART"
  final val ERFKILL         = "ERFKILL"
  final val EROFS           = "EROFS"
  final val ESHUTDOWN       = "ESHUTDOWN"
  final val ESOCKTNOSUPPORT = "ESOCKTNOSUPPORT"
  final val ESPIPE          = "ESPIPE"
  final val ESRCH           = "ESRCH"
  final val ESTALE          = "ESTALE"
  final val ESTRPIPE        = "ESTRPIPE"
  final val ETIME           = "ETIME"
  final val ETIMEDOUT       = "ETIMEDOUT"
  final val ETOOMANYREFS    = "ETOOMANYREFS"
  final val ETXTBSY         = "ETXTBSY"
  final val EUCLEAN         = "EUCLEAN"
  final val EUNATCH         = "EUNATCH"
  final val EUSERS          = "EUSERS"
  final val EWOULDBLOCK     = "EWOULDBLOCK"
  final val EXDEV           = "EXDEV"
  final val EXFULL          = "EXFULL"
}
