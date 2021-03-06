package pef.utils

import pef.parseAsHex
import pef.PasswordProvider
import pef.par.KMe
import pef.par.KContact

object ClothesShop
{
   private val passwordProvider = object : PasswordProvider {override fun password () = "hardwarestore" }
   private val salt = "4e28dc4a0269839a9505896cd1747b174e5b5d15c8448d30012051666a8fd570".parseAsHex()

   val contact = KContact(
      10L,
      address = KContact.KAddress(
         "clothing", "supplier", "21189ae6fbf9c06c16a40e1d64723a64769d70b245ffb8f21628e25a1a595226".parseAsHex()
      )
   )

   fun irohaSignatory () = KMe( contact, salt ).irohaSignatory( passwordProvider )
}
