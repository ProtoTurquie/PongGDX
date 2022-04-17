package libgdxTemplate

lateinit var platformCode : PlatformSpecific

interface PlatformSpecific {
    fun generateFont()
}