package io.scalajs.nodejs

import scala.scalajs.js

/** query string package object
  */
package object querystring {

  /** Query String Enrichment
    * @param qs
    *   the given [[QueryString]]
    */
  implicit final class QueryStringEnrichment(private val qs: QueryString) extends AnyVal {
    @inline
    def parseAs[T <: js.Object](str: String, sep: String, eq: String, options: QueryDecodeOptions): T = {
      qs.parse(str, sep, eq, options).asInstanceOf[T]
    }

    @inline
    def parseAs[T <: js.Object](str: String, sep: String, eq: String): T = {
      qs.parse(str, sep, eq).asInstanceOf[T]
    }

    @inline
    def parseAs[T <: js.Object](str: String, sep: String): T = {
      qs.parse(str, sep).asInstanceOf[T]
    }

    @inline
    def parseAs[T <: js.Object](str: String): T = {
      qs.parse(str).asInstanceOf[T]
    }
  }
}
