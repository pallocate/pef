package pef.par

import kotlinx.serialization.Serializable
import pef.Voidable
import pef.eco.Target

@Serializable
class KRelation (val other : KContact, val target : Target = Target.UNDEFINED) : Voidable
{
   companion object
   {fun void () = KRelation( KContact.void() )}

   val roles : ArrayList<Role> = ArrayList<Role>()

   override fun isVoid () = other.isVoid()
   override fun toString () = "${other.info.name}" + if (target == Target.UNDEFINED) "" else " (${target.tag()})"
}
