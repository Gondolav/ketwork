package ch.gondolav.ketwork

/**
 * A listener used to specify the actions to perform on Internet connection on/off.
 */
class ConnectionListener internal constructor() {

    var off: () -> Unit = {}
    var on: () -> Unit = {}

    /**
     * Block to run on Internet connection off.
     */
    fun off(off: () -> Unit) {
        this.off = off
    }

    /**
     * Block to run on Internet connection on.
     */
    fun on(on: () -> Unit) {
        this.on = on
    }
}