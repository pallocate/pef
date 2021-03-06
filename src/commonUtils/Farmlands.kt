package pef.utils

import pef.parseAsHex
import pef.PasswordProvider
import pef.eco.Target
import pef.par.*

object Farmlands
{
   private val passwordProvider = object : PasswordProvider {override fun password () = "farmlands" }
   private val salt = "cb0812c14288ff2c70fd79fecf8cc27a2b553799be3f5092664223fd988b371a".parseAsHex()

   val contact = KContact(
      7L,
      KContact.KInfo( "Farmlands" ),
      KContact.KAddress(
         "farmlands", "commons", "a8e1f28b14c80d53b9a4eb099528efdd714962324fc429135c086ec7e709d5d5".parseAsHex()
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
