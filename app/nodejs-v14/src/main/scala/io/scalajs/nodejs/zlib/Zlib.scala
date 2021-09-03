package io.scalajs.nodejs.zlib

import com.thoughtworks.enableIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/** This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes. Each class takes the same
  * options, and is a readable/writable Stream.
  * @see
  *   https://nodejs.org/docs/latest/api/zlib.html
  */
@js.native
trait Zlib extends js.Object with UncategorizedConstants with ZlibConstants {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def createBrotliCompress(
      options: BrotliOptions
  ): BrotliCompress = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def createBrotliCompress(): BrotliCompress =
    js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def createBrotliDecompress(
      options: BrotliOptions
  ): BrotliDecompress = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def createBrotliDecompress(): BrotliDecompress =
    js.native

  /** Returns a new Deflate object with an options.
    * @example
    *   zlib.createDeflate(options)
    */
  def createDeflate(options: CompressionOptions): Deflate = js.native

  /** Returns a new DeflateRaw object with an options.
    * @example
    *   zlib.createDeflateRaw(options)
    */
  def createDeflateRaw(options: CompressionOptions): DeflateRaw = js.native
  def createDeflateRaw(): DeflateRaw                            = js.native

  /** Returns a new Gunzip object with an options.
    * @example
    *   zlib.createGunzip(options)
    */
  def createGunzip(options: CompressionOptions): Gunzip = js.native
  def createGunzip(): Gunzip                            = js.native

  /** Returns a new Gzip object with an options.
    * @example
    *   zlib.createGzip(options)
    */
  def createGzip(options: CompressionOptions): Gzip = js.native
  def createGzip(): Gzip                            = js.native

  /** Returns a new Inflate object with an options.
    * @example
    *   zlib.createInflate(options)
    */
  def createInflate(options: CompressionOptions): Inflate = js.native
  def createInflate(): Inflate                            = js.native

  /** Returns a new InflateRaw object with an options.
    * @example
    *   zlib.createInflateRaw(options)
    */
  def createInflateRaw(options: CompressionOptions): InflateRaw = js.native
  def createInflateRaw(): InflateRaw                            = js.native

  /** Returns a new Unzip object with an options.
    * @example
    *   zlib.createUnzip(options)
    */
  def createUnzip(options: CompressionOptions): Unzip = js.native
  def createUnzip(): Unzip                            = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Convenience Methods
  /////////////////////////////////////////////////////////////////////////////////

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def brotliCompress(buffer: Data, options: BrotliOptions, callback: js.Function): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def brotliCompress(buffer: Data, callback: js.Function): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def brotliCompressSync(buffer: Data,
                                                                                            options: BrotliOptions
  ): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def brotliCompressSync(buffer: Data): Unit =
    js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def brotliDecompress(buffer: Data, options: BrotliOptions, callback: js.Function): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def brotliDecompress(buffer: Data, callback: js.Function): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def brotliDecompressSync(buffer: Data,
                                                                                              options: BrotliOptions
  ): Unit = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) def brotliDecompressSync(buffer: Data): Unit =
    js.native

  /** Compress a Buffer or string with Deflate.
    * @example
    *   zlib.deflate(buf[, options], callback)
    */
  def deflate(buffer: Data, options: CompressionOptions, callback: js.Function): Unit = js.native
  def deflate(buffer: Data, callback: js.Function): Unit                              = js.native

  /** Compress a Buffer or string with Deflate.
    * @example
    *   zlib.deflateSync(buf[, options])
    */
  def deflateSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def deflateSync(buffer: Data): Unit                              = js.native

  /** Compress a Buffer or string with DeflateRaw.
    * @example
    *   zlib.deflateRaw(buf[, options], callback)
    */
  def deflateRaw(buffer: Data, options: CompressionOptions, callback: js.Function): Unit =
    js.native
  def deflateRaw(buffer: Data, callback: js.Function): Unit           = js.native
  def deflateRawSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def deflateRawSync(buffer: Data): Unit                              = js.native

  /** Decompress a Buffer or string with Gunzip.
    * @example
    *   zlib.gunzip(buf[, options], callback)
    */
  def gunzip(buffer: Data, options: CompressionOptions, callback: js.Function): Unit = js.native
  def gunzip(buffer: Data, callback: js.Function): Unit                              = js.native

  /** Decompress a Buffer or string with Gunzip.
    * @example
    *   zlib.gunzipSync(buf[, options])
    */
  def gunzipSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def gunzipSync(buffer: Data): Unit                              = js.native

  /** Compress a Buffer or string with Gzip.
    * @example
    *   zlib.gzip(buf[, options], callback)
    */
  def gzip(buffer: Data, options: CompressionOptions, callback: js.Function): Unit = js.native
  def gzip(buffer: Data, callback: js.Function): Unit                              = js.native

  /** Compress a Buffer or string with Gzip.
    * @example
    *   zlib.gzipSync(buf[, options])
    */
  def gzipSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def gzipSync(buffer: Data): Unit                              = js.native

  /** Decompress a Buffer or string with Inflate.
    * @example
    *   zlib.inflate(buf[, options], callback)
    */
  def inflate(buffer: Data, options: CompressionOptions, callback: js.Function): Unit = js.native
  def inflate(buffer: Data, callback: js.Function): Unit                              = js.native

  /** Decompress a Buffer or string with Inflate.
    * @example
    *   zlib.inflateSync(buf[, options])
    */
  def inflateSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def inflateSync(buffer: Data): Unit                              = js.native

  /** Decompress a Buffer or string with InflateRaw.
    * @example
    *   zlib.inflateRaw(buf[, options], callback)
    */
  def inflateRaw(buffer: Data, options: CompressionOptions, callback: js.Function): Unit =
    js.native
  def inflateRaw(buffer: Data, callback: js.Function): Unit = js.native

  /** Decompress a Buffer or string with InflateRaw.
    * @example
    *   zlib.inflateRawSync(buf[, options])
    */
  def inflateRawSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def inflateRawSync(buffer: Data): Unit                              = js.native

  /** Decompress a Buffer or string with Unzip.
    * @example
    *   zlib.unzip(buf[, options], callback)
    */
  def unzip(buffer: Data, options: CompressionOptions, callback: js.Function): Unit = js.native
  def unzip(buffer: Data, callback: js.Function): Unit                              = js.native

  /** Decompress a Buffer or string with Unzip.
    * @example
    *   zlib.unzipSync(buf[, options])
    */
  def unzipSync(buffer: Data, options: CompressionOptions): Unit = js.native
  def unzipSync(buffer: Data): Unit                              = js.native
}

/** Zlib Singleton
  */
@js.native
@JSImport("zlib", JSImport.Namespace)
object Zlib extends Zlib
