package libgdxTemplate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter


class DesktopImplementation : PlatformSpecific{
    // override the overrides here
    override fun generateFont()
    {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("Lato-regular.ttf"))
        val parameter = FreeTypeFontParameter()
        parameter.size = 90
        font = generator.generateFont(parameter) // font size 12 pixels

        generator.dispose() // don't forget to dispose to avoid memory leaks!

    }
}
