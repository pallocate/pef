package pef.eco

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import pef.toLong
import pef.toInt
import pef.Voidable

@Serializable
@SerialName("Product")
open class KProduct_v1 (
   val id : Long = 0L,
   val name : String = "",
   val desc : String = "",
   val amount : Float = 0F,
   val prefix : Prefix = Prefix.NONE,
   val unit : Units = Units.NONE,
   val change : Int = 0,
   val price : Long = 0L,
   val sensitive : Boolean = false,
   val analogue : Boolean = false
) : Voidable
{
   /** @constructor Does some parameter checking/conversion and calls primary constructor. */
   constructor (id : String, name : String, desc : String, amount : String, prefix : String, unit : String,
      change : String, price : String, sensitive : String, analogue : String) : this
   (
      id.toLong(),
      name,
      desc,
      amount.toFloat(),
      prefix.toPrefix(),
      unit.toUnit(),
      change.toInt(),
      price.toLong(),
      sensitive.toBool(),
      analogue.toBool()
   )

   companion object
   { fun void () = KProduct_v1() }

   fun apu () : String
   {
      val stringBuilder = StringBuilder()

      if (prefix > Prefix.NONE)
         stringBuilder.append( prefix.tag() )

      if (unit > Units.NONE)
         stringBuilder.append( unit.tag() )

      if (!stringBuilder.isEmpty())
         if (amount > 0F)
            stringBuilder.insert( 0, amount )
         else
            stringBuilder.insert( 0, 1 )

      return stringBuilder.toString()
   }

   override fun isVoid () = (id == 0L)
   override fun toString () = name
}
