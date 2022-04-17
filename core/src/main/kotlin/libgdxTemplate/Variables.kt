package libgdxTemplate

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import libgdxTemplate.pongClasses.Ball
import libgdxTemplate.pongClasses.Paddle
import libgdxTemplate.pongClasses.ScoreCounter
import libgdxTemplate.pongClasses.Trigger


var paddle_width = 0.5f ; var paddle_height = 3f ; var ball_size = 0.4f
var border_size = 0.1f ; var paddle_speed = 5f ; var ball_speed = 10f

var paddles = mutableListOf<Paddle>()
var balls = mutableListOf<Ball>()
var triggers = mutableListOf<Trigger>()
var scoreCounter = ScoreCounter()
    .apply {
        addTeam("team1")
        addTeam("team2")
    }

lateinit var font : BitmapFont


var renderer = ShapeRenderer()
var uiViewport = FillViewport(640f, 480f)
var uiBatch = SpriteBatch()
var viewport = FitViewport(15f, 10f)
var batch = SpriteBatch()
lateinit var centralScreen : MainScreen

var gameArea = Rectangle( // max area is height instead of y+height
    0.1f, 0.1f, viewport.worldWidth, viewport.worldHeight - 0.1f
)
var ballFrozen = true