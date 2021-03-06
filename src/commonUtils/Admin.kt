package pef.utils

import pef.parseAsHex
import pef.PasswordProvider
import pef.par.KMe
import pef.par.KContact

object Admin
{
   private val passwordProvider = object : PasswordProvider {override fun password () = "admin" }
   private val salt = "6c4d810f497c4562d70e11e8c329add6dc946a3e0d0be419446864a903a2f046".parseAsHex()

   val contact = KContact(
      0L,
      KContact.KInfo( "Admin" ),
      KContact.KAddress( "admin", "system" )
   )

   fun irohaSignatory () = KMe( contact, salt ).irohaSignatory( passwordProvider )
}
// pk: "d22675d937af2c0cea3a54057148e8c3467fea9ae08236c2fd2a2e06f68fba79"
