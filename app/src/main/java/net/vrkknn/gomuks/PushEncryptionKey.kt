package net.vrkknn.gomuks

import android.content.Context
import android.content.SharedPreferences
import android.util.Base64

internal fun getExistingPushEncryptionKey(
    context: Context,
): ByteArray? {
    return getPushEncryptionKey(context, false, null, null)
}

internal fun getOrCreatePushEncryptionKey(
    context: Context,
    prefEncParam: Encryption,
    sharedPrefParam: SharedPreferences,
): ByteArray {
    return getPushEncryptionKey(context, true, prefEncParam, sharedPrefParam)!!
}

private fun getPushEncryptionKey(
    context: Context,
    allowGenerate: Boolean,
    prefEncParam: Encryption?,
    sharedPrefParam: SharedPreferences?,
): ByteArray? {
    val prefEnc = prefEncParam ?: Encryption(context.getString(R.string.pref_enc_key_name))
    val sharedPref = sharedPrefParam ?: context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
    val encryptedKey = sharedPref.getString(context.getString(R.string.push_enc_key), null)
    val unencKey: ByteArray
    if (encryptedKey == null) {
        if (!allowGenerate) {
            return null
        }
        unencKey = Encryption.generatePlainKey()
        with(sharedPref.edit()) {
            putString(
                context.getString(R.string.push_enc_key),
                Base64.encodeToString(prefEnc.encrypt(unencKey), Base64.NO_WRAP)
            )
            apply()
        }
        return unencKey
    } else {
        return prefEnc.decrypt(Base64.decode(encryptedKey, Base64.DEFAULT))
    }
}
