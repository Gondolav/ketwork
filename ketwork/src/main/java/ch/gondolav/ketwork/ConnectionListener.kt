package ch.gondolav.ketwork

/**
 * A listener used to specify the actions to perform on Internet connection on/off.
 */
class ConnectionListener @PublishedApi internal constructor() {

    @PublishedApi
    internal var off: () -> Unit = {}
    @PublishedApi
    internal var on: () -> Unit = {}

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