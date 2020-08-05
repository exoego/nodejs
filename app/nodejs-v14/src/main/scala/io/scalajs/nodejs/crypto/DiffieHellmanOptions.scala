package io.scalajs.nodejs.crypto

import scala.scalajs.js
import net.exoego.scalajs.types.util.Factory

@Factory
trait DiffieHellmanOptions extends js.Object {
  var privateKey: KeyObject
  var publicKey: KeyObject
}
