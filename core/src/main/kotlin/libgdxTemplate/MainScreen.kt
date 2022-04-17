package libgdxTemplate

import com.badlogic.gdx.Screen
import libgdxTemplate.pongClasses.Ball
import libgdxTemplate.pongClasses.Paddle
import libgdxTemplate.pongClasses.Trigger


class MainScreen : Screen
{

    override fun show() {
        platformCode.generateFont()

        balls.add(Ball()
            .apply { centerPosition() })
        paddles.add(Paddle(1f, gameArea.height/2 - paddle_height/2))

        paddles.add(Paddle(14f - paddle_width, gameArea.height/2 - paddle_height/2))
        triggers.add(
            Trigger(
                {
                    scoreCounter.addScore("team2", 1)
                    balls.map { it.centerPosition() }
                }
            )
                .apply
                {
                    set(0f, 0f, 1f, gameArea.height)
                }
        )
        triggers.add(
            Trigger(
                {
                    scoreCounter.addScore("team1", 1)
                    balls.map { it.centerPosition() }
                }
            )
                .apply
                {
                    set(14f, 0f, 1f, gameArea.height)
                }
        )

    }
    override fun render(delta: Float) {


        input(this, delta)
        logic(this, delta)
        draw(this, delta)
        drawui(this, delta)


    }

    override fun dispose() {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
        uiViewport.update(width, height, true)
    }
    override fun hide() {
    }
}