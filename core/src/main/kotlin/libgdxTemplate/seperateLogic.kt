package libgdxTemplate

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ScreenUtils

fun drawui(screen: MainScreen, delta: Float)
{
    screen.apply {
        uiViewport.apply()
        uiBatch.projectionMatrix = uiViewport.camera.combined
        uiBatch.begin()

        font.draw(uiBatch, "${scoreCounter.scores["team1"]}", 230f, 420f)
        font.draw(uiBatch, "${scoreCounter.scores["team2"]}", 360f, 420f)


        uiBatch.end()
    }
}
fun draw(screen: MainScreen, delta: Float)
{
    screen.apply {
        ScreenUtils.clear(Color.DARK_GRAY)

        viewport.apply()
        batch.projectionMatrix = viewport.camera.combined
        renderer.projectionMatrix = viewport.camera.combined

        batch.begin()



        batch.end()


        renderer.begin(ShapeRenderer.ShapeType.Filled)
        renderer.color = Color.WHITE

        for(paddle in paddles)
            renderer.rect(paddle.x, paddle.y, paddle.width, paddle.height)
        for(ball in balls)
            renderer.rect(ball.x, ball.y, ball.width, ball.height)

        renderer.rect(gameArea.x - border_size, 0f, border_size, gameArea.height)
        renderer.rect(gameArea.width - border_size, 0f, border_size, gameArea.height)
        renderer.rect(gameArea.y - border_size, 0f, gameArea.width, border_size)
        renderer.rect(0f, gameArea.height, gameArea.width, border_size)

        renderer.color = Color.WHITE

        for(i in 0..15)
            if(i%2==0)renderer.rect(viewport.worldWidth/2 - 0.5f/2f, (10/15f)*i, 0.5f, 0.5f)

        renderer.end()

    }
}
fun logic(screen: MainScreen, delta: Float)
{
    screen.apply {
        for(ball in balls)
            if(!ballFrozen)ball.update(delta)
        for(paddle in paddles)
            paddle.update(delta)
        for(trigger in triggers)
            trigger.update()
        if(Gdx.input.isKeyPressed(Input.Keys.W)) paddles.first().y_ += delta * paddle_speed
        if(Gdx.input.isKeyPressed(Input.Keys.S)) paddles.first().y_ -= delta * paddle_speed
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) paddles[1].y_ += delta * paddle_speed
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) paddles[1].y_ -= delta * paddle_speed
    }
}
fun input(screen: MainScreen, delta: Float)
{
    screen.apply {
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)) scoreCounter.resetAllScores(0)
    }
}