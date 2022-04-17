package libgdxTemplate

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.viewport.Viewport

fun Rectangle.clampToGameArea()
{
    if(this.x < gameArea.x)
        this.x = gameArea.x
    if(this.y < gameArea.y)
        this.y = gameArea.y
    if(this.x + this.width > gameArea.width)
        this.x = gameArea.width - this.width
    if(this.y + this.height > gameArea.height)
        this.y = gameArea.height - this.height

}

fun Rectangle.AABB(other: Rectangle): Boolean
{
    return this.x < other.x + other.width &&
            this.x + this.width > other.x &&
            this.y < other.y + other.height &&
            this.y + this.height > other.y
}

fun Rectangle.DebugDraw(renderer: ShapeRenderer, viewport: Viewport)
{
    var flag = false
    if(!renderer.isDrawing)
    {
        flag = true
        renderer.begin()
    }
    renderer.rect(this.x, this.y, this.width, this.height)
    if(flag)
        renderer.end()
}