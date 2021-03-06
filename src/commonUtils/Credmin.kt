package pef.utils

import pef.parseAsHex
import pef.PasswordProvider
import pef.par.KMe
import pef.par.KContact

object Credmin
{
   private val passwordProvider = object : PasswordProvider {override fun password () = "credmin" }
   private val salt = "112c8707c1a59774fd32d3424dd38072ad3a1fbe12a590c3a3e6840ff961dc16".parseAsHex()

   val contact = KContact(
      0L,
      KContact.KInfo( "Credmin" ),
      KContact.KAddress( "credmin", "system" )
   )

   fun irohaSignatory () = KMe( contact, salt ).irohaSignatory( passwordProvider )
}
// pk: "fc754dd079e58de4cfdebbc06364d9b4e636287bb0a658f6f3550180bf5ad3ef"
