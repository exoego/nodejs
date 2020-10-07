package io.scalajs.nodejs

import com.thoughtworks.enableIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/** Creates a new Error object and sets the error.message property to the provided text message.
  * If an object is passed as message, the text message is generated by calling message.toString().
  * The error.stack property will represent the point in the code at which new Error() was called.
  * Stack traces are dependent on V8's stack trace API. Stack traces extend only to either (a) the
  * beginning of synchronous code execution, or (b) the number of frames given by the property
  * Error.stackTraceLimit, whichever is smaller.
  */
@js.native
@JSGlobal
class Error() extends js.Object {
  def this(message0: String) = this()

  /** The `error.code` property is a string label that identifies the kind of error.
    * `error.code` is the most stable way to identify an error.
    * It will only change between major versions of Node.js.
    * In contrast, error.message strings may change between any versions of Node.js
    * See Node.js Error Codes for details about specific codes.
    */
  val code: String = js.native

  /** The error.message property is the string description of the error as set by calling new Error(message).
    * The message passed to the constructor will also appear in the first line of the stack trace of the Error,
    * however changing this property after the Error object is created may not change the first line of the
    * stack trace (for example, when error.stack is read before this property is changed).
    */
  val message: String = js.native

  /** The error.stack property is a string describing the point in the code at which the Error was instantiated.
    */
  val stack: js.Any = js.native
}

/** Error Singleton
  */
@js.native
@JSGlobal
object Error extends js.Object {
  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /** Error.stackTraceLimit
    */
  def stackTraceLimit: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /** Creates a .stack property on targetObject, which when accessed returns a string representing the location in the
    * code at which Error.captureStackTrace() was called.
    * @param targetObject   The first line of the trace, instead of being prefixed with ErrorType: message, will be the
    *                       result of calling targetObject.toString().
    * @param constructorOpt The optional constructorOpt argument accepts a function. If given, all frames above
    *                       constructorOpt, including constructorOpt, will be omitted from the generated stack trace.
    *                       The constructorOpt argument is useful for hiding implementation details of error generation
    *                       from an end user.
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any, constructorOpt: js.Any): Unit = js.native
  def captureStackTrace(targetObject: js.Any): Unit                         = js.native
}

object ErrorCodes {
  final val ERR_AMBIGUOUS_ARGUMENT                           = "ERR_AMBIGUOUS_ARGUMENT"
  final val ERR_ARG_NOT_ITERABLE                             = "ERR_ARG_NOT_ITERABLE"
  final val ERR_ASSERTION                                    = "ERR_ASSERTION"
  final val ERR_ASYNC_CALLBACK                               = "ERR_ASYNC_CALLBACK"
  final val ERR_ASYNC_TYPE                                   = "ERR_ASYNC_TYPE"
  final val ERR_BROTLI_COMPRESSION_FAILED                    = "ERR_BROTLI_COMPRESSION_FAILED"
  final val ERR_BROTLI_INVALID_PARAM                         = "ERR_BROTLI_INVALID_PARAM"
  final val ERR_BUFFER_CONTEXT_NOT_AVAILABLE                 = "ERR_BUFFER_CONTEXT_NOT_AVAILABLE"
  final val ERR_BUFFER_OUT_OF_BOUNDS                         = "ERR_BUFFER_OUT_OF_BOUNDS"
  final val ERR_BUFFER_TOO_LARGE                             = "ERR_BUFFER_TOO_LARGE"
  final val ERR_CANNOT_WATCH_SIGINT                          = "ERR_CANNOT_WATCH_SIGINT"
  final val ERR_CHILD_CLOSED_BEFORE_REPLY                    = "ERR_CHILD_CLOSED_BEFORE_REPLY"
  final val ERR_CHILD_PROCESS_IPC_REQUIRED                   = "ERR_CHILD_PROCESS_IPC_REQUIRED"
  final val ERR_CHILD_PROCESS_STDIO_MAXBUFFER                = "ERR_CHILD_PROCESS_STDIO_MAXBUFFER"
  final val ERR_CONSOLE_WRITABLE_STREAM                      = "ERR_CONSOLE_WRITABLE_STREAM"
  final val ERR_CONSTRUCT_CALL_REQUIRED                      = "ERR_CONSTRUCT_CALL_REQUIRED"
  final val ERR_CONSTRUCT_CALL_INVALID                       = "ERR_CONSTRUCT_CALL_INVALID"
  final val ERR_CPU_USAGE                                    = "ERR_CPU_USAGE"
  final val ERR_CRYPTO_CUSTOM_ENGINE_NOT_SUPPORTED           = "ERR_CRYPTO_CUSTOM_ENGINE_NOT_SUPPORTED"
  final val ERR_CRYPTO_ECDH_INVALID_FORMAT                   = "ERR_CRYPTO_ECDH_INVALID_FORMAT"
  final val ERR_CRYPTO_ECDH_INVALID_PUBLIC_KEY               = "ERR_CRYPTO_ECDH_INVALID_PUBLIC_KEY"
  final val ERR_CRYPTO_ENGINE_UNKNOWN                        = "ERR_CRYPTO_ENGINE_UNKNOWN"
  final val ERR_CRYPTO_FIPS_FORCED                           = "ERR_CRYPTO_FIPS_FORCED"
  final val ERR_CRYPTO_FIPS_UNAVAILABLE                      = "ERR_CRYPTO_FIPS_UNAVAILABLE"
  final val ERR_CRYPTO_HASH_DIGEST_NO_UTF16                  = "ERR_CRYPTO_HASH_DIGEST_NO_UTF16"
  final val ERR_CRYPTO_HASH_FINALIZED                        = "ERR_CRYPTO_HASH_FINALIZED"
  final val ERR_CRYPTO_HASH_UPDATE_FAILED                    = "ERR_CRYPTO_HASH_UPDATE_FAILED"
  final val ERR_CRYPTO_INCOMPATIBLE_KEY_OPTIONS              = "ERR_CRYPTO_INCOMPATIBLE_KEY_OPTIONS"
  final val ERR_CRYPTO_INVALID_DIGEST                        = "ERR_CRYPTO_INVALID_DIGEST"
  final val ERR_CRYPTO_INVALID_KEY_OBJECT_TYPE               = "ERR_CRYPTO_INVALID_KEY_OBJECT_TYPE"
  final val ERR_CRYPTO_INVALID_STATE                         = "ERR_CRYPTO_INVALID_STATE"
  final val ERR_CRYPTO_PBKDF2_ERROR                          = "ERR_CRYPTO_PBKDF2_ERROR"
  final val ERR_CRYPTO_SCRYPT_INVALID_PARAMETER              = "ERR_CRYPTO_SCRYPT_INVALID_PARAMETER"
  final val ERR_CRYPTO_SCRYPT_NOT_SUPPORTED                  = "ERR_CRYPTO_SCRYPT_NOT_SUPPORTED"
  final val ERR_CRYPTO_SIGN_KEY_REQUIRED                     = "ERR_CRYPTO_SIGN_KEY_REQUIRED"
  final val ERR_CRYPTO_TIMING_SAFE_EQUAL_LENGTH              = "ERR_CRYPTO_TIMING_SAFE_EQUAL_LENGTH"
  final val ERR_DNS_SET_SERVERS_FAILED                       = "ERR_DNS_SET_SERVERS_FAILED"
  final val ERR_DOMAIN_CALLBACK_NOT_AVAILABLE                = "ERR_DOMAIN_CALLBACK_NOT_AVAILABLE"
  final val ERR_DOMAIN_CANNOT_SET_UNCAUGHT_EXCEPTION_CAPTURE = "ERR_DOMAIN_CANNOT_SET_UNCAUGHT_EXCEPTION_CAPTURE"
  final val ERR_ENCODING_INVALID_ENCODED_DATA                = "ERR_ENCODING_INVALID_ENCODED_DATA"
  final val ERR_ENCODING_NOT_SUPPORTED                       = "ERR_ENCODING_NOT_SUPPORTED"
  final val ERR_FALSY_VALUE_REJECTION                        = "ERR_FALSY_VALUE_REJECTION"
  final val ERR_FS_FILE_TOO_LARGE                            = "ERR_FS_FILE_TOO_LARGE"
  final val ERR_FS_INVALID_SYMLINK_TYPE                      = "ERR_FS_INVALID_SYMLINK_TYPE"
  final val ERR_HTTP_HEADERS_SENT                            = "ERR_HTTP_HEADERS_SENT"
  final val ERR_HTTP_INVALID_HEADER_VALUE                    = "ERR_HTTP_INVALID_HEADER_VALUE"
  final val ERR_HTTP_INVALID_STATUS_CODE                     = "ERR_HTTP_INVALID_STATUS_CODE"
  final val ERR_HTTP_TRAILER_INVALID                         = "ERR_HTTP_TRAILER_INVALID"
  final val ERR_HTTP2_ALTSVC_INVALID_ORIGIN                  = "ERR_HTTP2_ALTSVC_INVALID_ORIGIN"
  final val ERR_HTTP2_ALTSVC_LENGTH                          = "ERR_HTTP2_ALTSVC_LENGTH"
  final val ERR_HTTP2_CONNECT_AUTHORITY                      = "ERR_HTTP2_CONNECT_AUTHORITY"
  final val ERR_HTTP2_CONNECT_PATH                           = "ERR_HTTP2_CONNECT_PATH"
  final val ERR_HTTP2_CONNECT_SCHEME                         = "ERR_HTTP2_CONNECT_SCHEME"
  final val ERR_HTTP2_ERROR                                  = "ERR_HTTP2_ERROR"
  final val ERR_HTTP2_GOAWAY_SESSION                         = "ERR_HTTP2_GOAWAY_SESSION"
  final val ERR_HTTP2_HEADERS_AFTER_RESPOND                  = "ERR_HTTP2_HEADERS_AFTER_RESPOND"
  final val ERR_HTTP2_HEADERS_SENT                           = "ERR_HTTP2_HEADERS_SENT"
  final val ERR_HTTP2_HEADER_SINGLE_VALUE                    = "ERR_HTTP2_HEADER_SINGLE_VALUE"
  final val ERR_HTTP2_INFO_STATUS_NOT_ALLOWED                = "ERR_HTTP2_INFO_STATUS_NOT_ALLOWED"
  final val ERR_HTTP2_INVALID_CONNECTION_HEADERS             = "ERR_HTTP2_INVALID_CONNECTION_HEADERS"
  final val ERR_HTTP2_INVALID_HEADER_VALUE                   = "ERR_HTTP2_INVALID_HEADER_VALUE"
  final val ERR_HTTP2_INVALID_INFO_STATUS                    = "ERR_HTTP2_INVALID_INFO_STATUS"
  final val ERR_HTTP2_INVALID_ORIGIN                         = "ERR_HTTP2_INVALID_ORIGIN"
  final val ERR_HTTP2_INVALID_PACKED_SETTINGS_LENGTH         = "ERR_HTTP2_INVALID_PACKED_SETTINGS_LENGTH"
  final val ERR_HTTP2_INVALID_PSEUDOHEADER                   = "ERR_HTTP2_INVALID_PSEUDOHEADER"
  final val ERR_HTTP2_INVALID_SESSION                        = "ERR_HTTP2_INVALID_SESSION"
  final val ERR_HTTP2_INVALID_SETTING_VALUE                  = "ERR_HTTP2_INVALID_SETTING_VALUE"
  final val ERR_HTTP2_INVALID_STREAM                         = "ERR_HTTP2_INVALID_STREAM"
  final val ERR_HTTP2_MAX_PENDING_SETTINGS_ACK               = "ERR_HTTP2_MAX_PENDING_SETTINGS_ACK"
  final val ERR_HTTP2_NESTED_PUSH                            = "ERR_HTTP2_NESTED_PUSH"
  final val ERR_HTTP2_NO_SOCKET_MANIPULATION                 = "ERR_HTTP2_NO_SOCKET_MANIPULATION"
  final val ERR_HTTP2_ORIGIN_LENGTH                          = "ERR_HTTP2_ORIGIN_LENGTH"
  final val ERR_HTTP2_OUT_OF_STREAMS                         = "ERR_HTTP2_OUT_OF_STREAMS"
  final val ERR_HTTP2_PAYLOAD_FORBIDDEN                      = "ERR_HTTP2_PAYLOAD_FORBIDDEN"
  final val ERR_HTTP2_PING_CANCEL                            = "ERR_HTTP2_PING_CANCEL"
  final val ERR_HTTP2_PING_LENGTH                            = "ERR_HTTP2_PING_LENGTH"
  final val ERR_HTTP2_PSEUDOHEADER_NOT_ALLOWED               = "ERR_HTTP2_PSEUDOHEADER_NOT_ALLOWED"
  final val ERR_HTTP2_PUSH_DISABLED                          = "ERR_HTTP2_PUSH_DISABLED"
  final val ERR_HTTP2_SEND_FILE                              = "ERR_HTTP2_SEND_FILE"
  final val ERR_HTTP2_SEND_FILE_NOSEEK                       = "ERR_HTTP2_SEND_FILE_NOSEEK"
  final val ERR_HTTP2_SESSION_ERROR                          = "ERR_HTTP2_SESSION_ERROR"
  final val ERR_HTTP2_SETTINGS_CANCEL                        = "ERR_HTTP2_SETTINGS_CANCEL"
  final val ERR_HTTP2_SOCKET_BOUND                           = "ERR_HTTP2_SOCKET_BOUND"
  final val ERR_HTTP2_SOCKET_UNBOUND                         = "ERR_HTTP2_SOCKET_UNBOUND"
  final val ERR_HTTP2_STATUS_101                             = "ERR_HTTP2_STATUS_101"
  final val ERR_HTTP2_STATUS_INVALID                         = "ERR_HTTP2_STATUS_INVALID"
  final val ERR_HTTP2_STREAM_CANCEL                          = "ERR_HTTP2_STREAM_CANCEL"
  final val ERR_HTTP2_STREAM_ERROR                           = "ERR_HTTP2_STREAM_ERROR"
  final val ERR_HTTP2_STREAM_SELF_DEPENDENCY                 = "ERR_HTTP2_STREAM_SELF_DEPENDENCY"
  final val ERR_HTTP2_TRAILERS_ALREADY_SENT                  = "ERR_HTTP2_TRAILERS_ALREADY_SENT"
  final val ERR_HTTP2_TRAILERS_NOT_READY                     = "ERR_HTTP2_TRAILERS_NOT_READY"
  final val ERR_HTTP2_UNSUPPORTED_PROTOCOL                   = "ERR_HTTP2_UNSUPPORTED_PROTOCOL"
  final val ERR_INTERNAL_ASSERTION                           = "ERR_INTERNAL_ASSERTION"
  final val ERR_INCOMPATIBLE_OPTION_PAIR                     = "ERR_INCOMPATIBLE_OPTION_PAIR"
  final val ERR_INPUT_TYPE_NOT_ALLOWED                       = "ERR_INPUT_TYPE_NOT_ALLOWED"
  final val ERR_INSPECTOR_ALREADY_CONNECTED                  = "ERR_INSPECTOR_ALREADY_CONNECTED"
  final val ERR_INSPECTOR_CLOSED                             = "ERR_INSPECTOR_CLOSED"
  final val ERR_INSPECTOR_COMMAND                            = "ERR_INSPECTOR_COMMAND"
  final val ERR_INSPECTOR_NOT_ACTIVE                         = "ERR_INSPECTOR_NOT_ACTIVE"
  final val ERR_INSPECTOR_NOT_AVAILABLE                      = "ERR_INSPECTOR_NOT_AVAILABLE"
  final val ERR_INSPECTOR_NOT_CONNECTED                      = "ERR_INSPECTOR_NOT_CONNECTED"
  final val ERR_INVALID_ADDRESS_FAMILY                       = "ERR_INVALID_ADDRESS_FAMILY"
  final val ERR_INVALID_ARG_TYPE                             = "ERR_INVALID_ARG_TYPE"
  final val ERR_INVALID_ARG_VALUE                            = "ERR_INVALID_ARG_VALUE"
  final val ERR_INVALID_ASYNC_ID                             = "ERR_INVALID_ASYNC_ID"
  final val ERR_INVALID_BUFFER_SIZE                          = "ERR_INVALID_BUFFER_SIZE"
  final val ERR_INVALID_CALLBACK                             = "ERR_INVALID_CALLBACK"
  final val ERR_INVALID_CHAR                                 = "ERR_INVALID_CHAR"
  final val ERR_INVALID_CURSOR_POS                           = "ERR_INVALID_CURSOR_POS"
  final val ERR_INVALID_FD                                   = "ERR_INVALID_FD"
  final val ERR_INVALID_FD_TYPE                              = "ERR_INVALID_FD_TYPE"
  final val ERR_INVALID_FILE_URL_HOST                        = "ERR_INVALID_FILE_URL_HOST"
  final val ERR_INVALID_FILE_URL_PATH                        = "ERR_INVALID_FILE_URL_PATH"
  final val ERR_INVALID_HANDLE_TYPE                          = "ERR_INVALID_HANDLE_TYPE"
  final val ERR_INVALID_HTTP_TOKEN                           = "ERR_INVALID_HTTP_TOKEN"
  final val ERR_INVALID_IP_ADDRESS                           = "ERR_INVALID_IP_ADDRESS"
  final val ERR_INVALID_OPT_VALUE                            = "ERR_INVALID_OPT_VALUE"
  final val ERR_INVALID_OPT_VALUE_ENCODING                   = "ERR_INVALID_OPT_VALUE_ENCODING"
  final val ERR_INVALID_PACKAGE_CONFIG                       = "ERR_INVALID_PACKAGE_CONFIG"
  final val ERR_INVALID_PERFORMANCE_MARK                     = "ERR_INVALID_PERFORMANCE_MARK"
  final val ERR_INVALID_PROTOCOL                             = "ERR_INVALID_PROTOCOL"
  final val ERR_INVALID_REPL_EVAL_CONFIG                     = "ERR_INVALID_REPL_EVAL_CONFIG"
  final val ERR_INVALID_REPL_INPUT                           = "ERR_INVALID_REPL_INPUT"
  final val ERR_INVALID_RETURN_PROPERTY                      = "ERR_INVALID_RETURN_PROPERTY"
  final val ERR_INVALID_RETURN_PROPERTY_VALUE                = "ERR_INVALID_RETURN_PROPERTY_VALUE"
  final val ERR_INVALID_RETURN_VALUE                         = "ERR_INVALID_RETURN_VALUE"
  final val ERR_INVALID_SYNC_FORK_INPUT                      = "ERR_INVALID_SYNC_FORK_INPUT"
  final val ERR_INVALID_THIS                                 = "ERR_INVALID_THIS"
  final val ERR_INVALID_TRANSFER_OBJECT                      = "ERR_INVALID_TRANSFER_OBJECT"
  final val ERR_INVALID_TUPLE                                = "ERR_INVALID_TUPLE"
  final val ERR_INVALID_URI                                  = "ERR_INVALID_URI"
  final val ERR_INVALID_URL                                  = "ERR_INVALID_URL"
  final val ERR_INVALID_URL_SCHEME                           = "ERR_INVALID_URL_SCHEME"
  final val ERR_IPC_CHANNEL_CLOSED                           = "ERR_IPC_CHANNEL_CLOSED"
  final val ERR_IPC_DISCONNECTED                             = "ERR_IPC_DISCONNECTED"
  final val ERR_IPC_ONE_PIPE                                 = "ERR_IPC_ONE_PIPE"
  final val ERR_IPC_SYNC_FORK                                = "ERR_IPC_SYNC_FORK"
  final val ERR_MANIFEST_ASSERT_INTEGRITY                    = "ERR_MANIFEST_ASSERT_INTEGRITY"
  final val ERR_MANIFEST_DEPENDENCY_MISSING                  = "ERR_MANIFEST_DEPENDENCY_MISSING"
  final val ERR_MANIFEST_INTEGRITY_MISMATCH                  = "ERR_MANIFEST_INTEGRITY_MISMATCH"
  final val ERR_MANIFEST_INVALID_RESOURCE_FIELD              = "ERR_MANIFEST_INVALID_RESOURCE_FIELD"
  final val ERR_MANIFEST_PARSE_POLICY                        = "ERR_MANIFEST_PARSE_POLICY"
  final val ERR_MANIFEST_TDZ                                 = "ERR_MANIFEST_TDZ"
  final val ERR_MANIFEST_UNKNOWN_ONERROR                     = "ERR_MANIFEST_UNKNOWN_ONERROR"
  final val ERR_MEMORY_ALLOCATION_FAILED                     = "ERR_MEMORY_ALLOCATION_FAILED"
  final val ERR_METHOD_NOT_IMPLEMENTED                       = "ERR_METHOD_NOT_IMPLEMENTED"
  final val ERR_MISSING_ARGS                                 = "ERR_MISSING_ARGS"
  final val ERR_MISSING_DYNAMIC_INSTANTIATE_HOOK             = "ERR_MISSING_DYNAMIC_INSTANTIATE_HOOK"
  final val ERR_MISSING_MESSAGE_PORT_IN_TRANSFER_LIST        = "ERR_MISSING_MESSAGE_PORT_IN_TRANSFER_LIST"
  final val ERR_MISSING_PASSPHRASE                           = "ERR_MISSING_PASSPHRASE"
  final val ERR_MISSING_PLATFORM_FOR_WORKER                  = "ERR_MISSING_PLATFORM_FOR_WORKER"
  final val ERR_MODULE_NOT_FOUND                             = "ERR_MODULE_NOT_FOUND"
  final val ERR_MULTIPLE_CALLBACK                            = "ERR_MULTIPLE_CALLBACK"
  final val ERR_NAPI_CONS_FUNCTION                           = "ERR_NAPI_CONS_FUNCTION"
  final val ERR_NAPI_INVALID_DATAVIEW_ARGS                   = "ERR_NAPI_INVALID_DATAVIEW_ARGS"
  final val ERR_NAPI_INVALID_TYPEDARRAY_ALIGNMENT            = "ERR_NAPI_INVALID_TYPEDARRAY_ALIGNMENT"
  final val ERR_NAPI_INVALID_TYPEDARRAY_LENGTH               = "ERR_NAPI_INVALID_TYPEDARRAY_LENGTH"
  final val ERR_NAPI_TSFN_CALL_JS                            = "ERR_NAPI_TSFN_CALL_JS"
  final val ERR_NAPI_TSFN_GET_UNDEFINED                      = "ERR_NAPI_TSFN_GET_UNDEFINED"
  final val ERR_NAPI_TSFN_START_IDLE_LOOP                    = "ERR_NAPI_TSFN_START_IDLE_LOOP"
  final val ERR_NAPI_TSFN_STOP_IDLE_LOOP                     = "ERR_NAPI_TSFN_STOP_IDLE_LOOP"
  final val ERR_NO_CRYPTO                                    = "ERR_NO_CRYPTO"
  final val ERR_NO_ICU                                       = "ERR_NO_ICU"
  final val ERR_OUT_OF_RANGE                                 = "ERR_OUT_OF_RANGE"
  final val ERR_REQUIRE_ESM                                  = "ERR_REQUIRE_ESM"
  final val ERR_SCRIPT_EXECUTION_INTERRUPTED                 = "ERR_SCRIPT_EXECUTION_INTERRUPTED"
  final val ERR_SCRIPT_EXECUTION_TIMEOUT                     = "ERR_SCRIPT_EXECUTION_TIMEOUT"
  final val ERR_SERVER_ALREADY_LISTEN                        = "ERR_SERVER_ALREADY_LISTEN"
  final val ERR_SERVER_NOT_RUNNING                           = "ERR_SERVER_NOT_RUNNING"
  final val ERR_SOCKET_ALREADY_BOUND                         = "ERR_SOCKET_ALREADY_BOUND"
  final val ERR_SOCKET_BAD_BUFFER_SIZE                       = "ERR_SOCKET_BAD_BUFFER_SIZE"
  final val ERR_SOCKET_BAD_PORT                              = "ERR_SOCKET_BAD_PORT"
  final val ERR_SOCKET_BAD_TYPE                              = "ERR_SOCKET_BAD_TYPE"
  final val ERR_SOCKET_BUFFER_SIZE                           = "ERR_SOCKET_BUFFER_SIZE"
  final val ERR_SOCKET_CLOSED                                = "ERR_SOCKET_CLOSED"
  final val ERR_SOCKET_DGRAM_IS_CONNECTED                    = "ERR_SOCKET_DGRAM_IS_CONNECTED"
  final val ERR_SOCKET_DGRAM_NOT_CONNECTED                   = "ERR_SOCKET_DGRAM_NOT_CONNECTED"
  final val ERR_SOCKET_DGRAM_NOT_RUNNING                     = "ERR_SOCKET_DGRAM_NOT_RUNNING"
  final val ERR_SRI_PARSE                                    = "ERR_SRI_PARSE"
  final val ERR_STREAM_CANNOT_PIPE                           = "ERR_STREAM_CANNOT_PIPE"
  final val ERR_STREAM_DESTROYED                             = "ERR_STREAM_DESTROYED"
  final val ERR_STREAM_NULL_VALUES                           = "ERR_STREAM_NULL_VALUES"
  final val ERR_STREAM_PREMATURE_CLOSE                       = "ERR_STREAM_PREMATURE_CLOSE"
  final val ERR_STREAM_PUSH_AFTER_EOF                        = "ERR_STREAM_PUSH_AFTER_EOF"
  final val ERR_STREAM_UNSHIFT_AFTER_END_EVENT               = "ERR_STREAM_UNSHIFT_AFTER_END_EVENT"
  final val ERR_STREAM_WRAP                                  = "ERR_STREAM_WRAP"
  final val ERR_STREAM_WRITE_AFTER_END                       = "ERR_STREAM_WRITE_AFTER_END"
  final val ERR_STRING_TOO_LONG                              = "ERR_STRING_TOO_LONG"
  final val ERR_SYNTHETIC                                    = "ERR_SYNTHETIC"
  final val ERR_SYSTEM_ERROR                                 = "ERR_SYSTEM_ERROR"
  final val ERR_TLS_CERT_ALTNAME_INVALID                     = "ERR_TLS_CERT_ALTNAME_INVALID"
  final val ERR_TLS_DH_PARAM_SIZE                            = "ERR_TLS_DH_PARAM_SIZE"
  final val ERR_TLS_HANDSHAKE_TIMEOUT                        = "ERR_TLS_HANDSHAKE_TIMEOUT"
  final val ERR_TLS_INVALID_PROTOCOL_METHOD                  = "ERR_TLS_INVALID_PROTOCOL_METHOD"
  final val ERR_TLS_INVALID_PROTOCOL_VERSION                 = "ERR_TLS_INVALID_PROTOCOL_VERSION"
  final val ERR_TLS_PROTOCOL_VERSION_CONFLICT                = "ERR_TLS_PROTOCOL_VERSION_CONFLICT"
  final val ERR_TLS_RENEGOTIATION_DISABLED                   = "ERR_TLS_RENEGOTIATION_DISABLED"
  final val ERR_TLS_REQUIRED_SERVER_NAME                     = "ERR_TLS_REQUIRED_SERVER_NAME"
  final val ERR_TLS_SESSION_ATTACK                           = "ERR_TLS_SESSION_ATTACK"
  final val ERR_TLS_SNI_FROM_SERVER                          = "ERR_TLS_SNI_FROM_SERVER"
  final val ERR_TRACE_EVENTS_CATEGORY_REQUIRED               = "ERR_TRACE_EVENTS_CATEGORY_REQUIRED"
  final val ERR_TRACE_EVENTS_UNAVAILABLE                     = "ERR_TRACE_EVENTS_UNAVAILABLE"
  final val ERR_TRANSFERRING_EXTERNALIZED_SHAREDARRAYBUFFER  = "ERR_TRANSFERRING_EXTERNALIZED_SHAREDARRAYBUFFER"
  final val ERR_TRANSFORM_ALREADY_TRANSFORMING               = "ERR_TRANSFORM_ALREADY_TRANSFORMING"
  final val ERR_TRANSFORM_WITH_LENGTH_0                      = "ERR_TRANSFORM_WITH_LENGTH_0"
  final val ERR_TTY_INIT_FAILED                              = "ERR_TTY_INIT_FAILED"
  final val ERR_UNCAUGHT_EXCEPTION_CAPTURE_ALREADY_SET       = "ERR_UNCAUGHT_EXCEPTION_CAPTURE_ALREADY_SET"
  final val ERR_UNESCAPED_CHARACTERS                         = "ERR_UNESCAPED_CHARACTERS"
  final val ERR_UNHANDLED_ERROR                              = "ERR_UNHANDLED_ERROR"
  final val ERR_UNKNOWN_BUILTIN_MODULE                       = "ERR_UNKNOWN_BUILTIN_MODULE"
  final val ERR_UNKNOWN_CREDENTIAL                           = "ERR_UNKNOWN_CREDENTIAL"
  final val ERR_UNKNOWN_ENCODING                             = "ERR_UNKNOWN_ENCODING"
  final val ERR_UNKNOWN_FILE_EXTENSION                       = "ERR_UNKNOWN_FILE_EXTENSION"
  final val ERR_UNKNOWN_MODULE_FORMAT                        = "ERR_UNKNOWN_MODULE_FORMAT"
  final val ERR_UNKNOWN_SIGNAL                               = "ERR_UNKNOWN_SIGNAL"
  final val ERR_V8BREAKITERATOR                              = "ERR_V8BREAKITERATOR"
  final val ERR_VALID_PERFORMANCE_ENTRY_TYPE                 = "ERR_VALID_PERFORMANCE_ENTRY_TYPE"
  final val ERR_VM_DYNAMIC_IMPORT_CALLBACK_MISSING           = "ERR_VM_DYNAMIC_IMPORT_CALLBACK_MISSING"
  final val ERR_VM_MODULE_ALREADY_LINKED                     = "ERR_VM_MODULE_ALREADY_LINKED"
  final val ERR_VM_MODULE_DIFFERENT_CONTEXT                  = "ERR_VM_MODULE_DIFFERENT_CONTEXT"
  final val ERR_VM_MODULE_LINKING_ERRORED                    = "ERR_VM_MODULE_LINKING_ERRORED"
  final val ERR_VM_MODULE_NOT_LINKED                         = "ERR_VM_MODULE_NOT_LINKED"
  final val ERR_VM_MODULE_NOT_MODULE                         = "ERR_VM_MODULE_NOT_MODULE"
  final val ERR_VM_MODULE_STATUS                             = "ERR_VM_MODULE_STATUS"
  final val ERR_WORKER_INVALID_EXEC_ARGV                     = "ERR_WORKER_INVALID_EXEC_ARGV"
  final val ERR_WORKER_PATH                                  = "ERR_WORKER_PATH"
  final val ERR_WORKER_UNSERIALIZABLE_ERROR                  = "ERR_WORKER_UNSERIALIZABLE_ERROR"
  final val ERR_WORKER_UNSUPPORTED_EXTENSION                 = "ERR_WORKER_UNSUPPORTED_EXTENSION"
  final val ERR_WORKER_UNSUPPORTED_OPERATION                 = "ERR_WORKER_UNSUPPORTED_OPERATION"
  final val ERR_ZLIB_INITIALIZATION_FAILED                   = "ERR_ZLIB_INITIALIZATION_FAILED"
  final val HPE_HEADER_OVERFLOW                              = "HPE_HEADER_OVERFLOW"
  final val MODULE_NOT_FOUND                                 = "MODULE_NOT_FOUND"

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.ltNodeJs14)
  final val ERR_SOCKET_CANNOT_SEND = "ERR_SOCKET_CANNOT_SEND"

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  final val ERR_DIR_CONCURRENT_OPERATION = "ERR_DIR_CONCURRENT_OPERATION"
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  final val ERR_TLS_INVALID_CONTEXT = "ERR_TLS_INVALID_CONTEXT"
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  final val ERR_TLS_INVALID_STATE = "ERR_TLS_INVALID_STATE"
}
