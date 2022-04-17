package libgdxTemplate.pongClasses

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Rectangle
import libgdxTemplate.*
import kotlin.math.abs
import kotlin.math.sign

class Paddle : Rectangle {

    constructor(x: Float, y: Float) : super()
    {
        set(x, y, paddle_width, paddle_height)
    }

    private var _temp = Rectangle()
    var y_ : Float
    set(value) {
        var up = (y - value).sign >= 0f
        _temp.set(this).setY(value)
        if(_temp.y < gameArea.y || _temp.y + height > gameArea.height)
            return
        for(ball in balls)
            if(_temp.AABB(ball))
            {
                ball.insidePaddle = true
                return
            }
        this.y = value
        return
    }
    get()
    {
        return y
    }

    fun update(delta: Float)
    {
        for(ball in balls)
            if(this.AABB(ball));
    }
}
