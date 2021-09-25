@file:kotlinx.serialization.UseSerializers( ByteArraySerialiser::class )

package pef.par

import pef.ByteArraySerialiser
import kotlinx.serialization.Serializable
import pef.PasswordProvider
import pef.randomBytes
import pef.KCrypto
import pef.IrohaSignatory
import pef.ed25519Sha3

@Serializable
class KMe (val contact : KContact, private val salt : ByteArray = randomBytes( KCrypto.SALT_SIZE ))
{
   fun crypto (passwordProvider : PasswordProvider) = KCrypto( passwordProvider, salt )

   fun irohaSignatory (passwordProvider : PasswordProvider) : IrohaSignatory
   {
      val seed = crypto( passwordProvider ).deriveKey()
      return ed25519Sha3( seed )
   }
}
