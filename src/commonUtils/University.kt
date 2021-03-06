package pef.utils

import pef.parseAsHex
import pef.PasswordProvider
import pef.eco.Target
import pef.par.*

object University
{
   private val passwordProvider = object : PasswordProvider {override fun password () = "university" }
   private val salt = "38a5a3f320bf5bd0813c71cfa41123567302158dbaec12d311b63dbd082b47f8".parseAsHex()

   val contact = KContact(
      1L,
      KContact.KInfo( "University" ),
      KContact.KAddress(
         "university", "commons", "6ae9b78e89aa41bfc5ab9d188f3c3b4723c512cb43068ab2b73a70e0173ec2e9".parseAsHex()
      )
   )


   private val me by lazy {KMe( contact, salt )}

   fun irohaSignatory () = me.irohaSignatory( passwordProvider )

   fun user () = KUser( me ).apply {
      relations.add(KRelation( Contacts.patricia, Target.PRODUCTION ).apply {
         roles.add( Role.CONCEDER )
         roles.add( Role.DATA_CONTROLLER )
      })

      relations.add(KRelation( Contacts.david, Target.PRODUCTION ).apply {
         roles.add( Role.CONCEDER )
         roles.add( Role.DATA_CONTROLLER )
      })
   }
}
