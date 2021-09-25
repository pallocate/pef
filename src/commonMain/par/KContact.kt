@file:kotlinx.serialization.UseSerializers( ByteArraySerialiser::class )

package pef.par

import pef.ByteArraySerialiser
import pef.VOID_BYTES
import pef.Voidable
import kotlinx.serialization.Serializable

@Serializable
data class KContact (val id : Long, val info : KInfo = KInfo(), val address : KAddress = KAddress()) : Voidable
{
   @Serializable
   data class KAddress (
      val member : String = "",                                                 // consignee
      val council : String = "",
      val publicKey : ByteArray = VOID_BYTES
   ) {}

   @Serializable
   data class KInfo (
      val name : String = "",
      val icon : String = "",
      val group : String = ""
   ) {}

   companion object
   {fun void () = KContact( 0L )}

   override fun isVoid () = (id == 0L)
   override fun toString () = info.name
}
