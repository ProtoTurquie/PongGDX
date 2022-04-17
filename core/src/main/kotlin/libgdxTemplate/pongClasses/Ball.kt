package libgdxTemplate.pongClasses

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import libgdxTemplate.*
import kotlin.concurrent.timer

class Ball : Rectangle {
    var speedX = ball_speed // x units per second
    var speedY= ball_speed
    constructor()
    {
        setSize(ball_size)
        setCenter(viewport.worldWidth / 2, viewport.worldHeight / 2)
        speedX *= MathUtils.randomSign()
        speedY *= MathUtils.randomSign()
    }

    var _temp = Rectangle() ; var _overlapped = false
    fun update(delta: Float)
    {
        if(!checkNextX(delta)) checkNextY(delta)

        _overlapped = false

    }
    fun checkNextX(delta: Float, velocityX: Float = speedX) : Boolean
    {
        _temp.set(this).x += velocityX * delta
        for(paddle in paddles)
        {
            if(_temp.overlaps(paddle))
            {
                speedX *= -1
                _overlapped = true
                break
            }
        }
        if(_temp.x + _temp.width > gameArea.width || _temp.x < gameArea.x)
        {
            speedX *= -1
            _overlapped = true
        }
        if(!_overlapped) setX(x + (velocityX * delta)) // we could obsolete this also but it would make a difference in a frame-scale
        _overlapped = false
        return _overlapped
    }
    fun checkNextY(delta: Float, velocityY: Float = speedY) : Boolean
    {
        _temp.set(this).y += velocityY * delta
        for(paddle in paddles)
        {
            if(_temp.overlaps(paddle))
            {
                speedY *= -1
                _overlapped = true
                break
            }
        }
        if(_temp.y + _temp.height > gameArea.height || _temp.y < gameArea.y)
        {
            speedY *= -1
            _overlapped = true
        }
        if(!_overlapped) setY(y + (velocityY * delta))
        clampToGameArea()
        return _overlapped
    }
    var insidePaddle = false

    fun centerPosition(randomDirection : Boolean = true)
    {
        setPosition(gameArea.width/2 - ball_size/2, gameArea.height/2 - ball_size/2)
        if(randomDirection)
        {
            speedX *= MathUtils.randomSign()
            speedY *= MathUtils.randomSign()
        }
        ballFrozen = true
        timer(null, true, 300, 10000L)
        {
            ballFrozen = false
            this.cancel()
        }
    }
}