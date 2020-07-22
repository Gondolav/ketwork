package ch.gondolav.ketwork

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * Returns true if the internet connection is on, false otherwise.
 *
 * @return true if the internet connection is on, false otherwise.
 */
fun Context.isInternetConnectionOn(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

    if (cm != null) {
        val n = cm.activeNetwork
        if (n != null) {
            val nc = cm.getNetworkCapabilities(n) ?: return false
            return nc.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI) || nc.hasTransport(
                NetworkCapabilities.TRANSPORT_VPN)
        }
    }

    return false
}

/**
 * Runs one of the given blocks based on whether Internet connection is on/off.
 *
 * @param builder a lambda specifying the blocks to execute based on Internet connectivity
 */
inline fun Context.runOnConnection(crossinline builder: ConnectionListener.() -> Unit) {
    val listener = ConnectionListener().apply(builder)
    if (!isInternetConnectionOn()) {
        listener.off()
    } else {
        listener.on()
    }
}

/**
 * Runs the given block only if the Internet connection is on.
 *
 * @param block the block to execute if the connection is on
 */
inline fun Context.runIfConnected(crossinline block: () -> Unit) {
    if (isInternetConnectionOn()) {
        block()
    }
}

/**
 * Runs the given block only if the Internet connection is off.
 *
 * @param block the block to execute if the connection is off
 */
inline fun Context.runIfDisconnected(crossinline block: () -> Unit) {
    if (!isInternetConnectionOn()) {
        block()
    }
}