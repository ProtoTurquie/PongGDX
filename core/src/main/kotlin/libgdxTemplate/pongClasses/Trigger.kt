package libgdxTemplate.pongClasses

import com.badlogic.gdx.math.Rectangle
import libgdxTemplate.AABB
import libgdxTemplate.balls

class Trigger : Rectangle {
    var action: () -> Unit = {}
    var list : MutableList<Ball> = balls
    var callOnlyOnce = true
    constructor(action: ()->Unit = {}, willCheckInsideThisList : MutableList<Ball> = balls) : super()
    {
        this.action = action
        list = willCheckInsideThisList
    }

    private var _lastBalls = mutableListOf<Ball>()
    fun update()
    {
        for(ball in list)
        {
            if(this.AABB(ball))
            {

                if(callOnlyOnce)
                {
                    if(!_lastBalls.contains(ball))
                    {
                        action()
                        _lastBalls.add(ball)
                    }
                }
                else action()
            }
            else
            {
                _lastBalls.remove(ball)
            }
        }
    }
}