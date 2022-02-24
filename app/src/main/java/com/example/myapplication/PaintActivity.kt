package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.example.myapplication.databinding.ActivityPaintBinding

class PaintActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaintBinding
    private var bitmap: Bitmap? = null
    private lateinit var canvas: Canvas

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var startX: Float? = null
        var startY: Float? = null
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 10f

        binding.backBtn.setOnClickListener {
            super.onBackPressed()
        }

        binding.color.setOnClickListener {

            val dialog = MaterialDialog(this)
                .title(text = "Choose color")
                .listItemsSingleChoice(
                    items = listOf("Red", "Blue", "Green", "Black"),
                    selection = { dialog, index, text ->

                        when (index) {
                            0 -> {
                                paint.color = Color.RED
                            }
                            1 -> {
                                paint.color = Color.BLUE
                            }
                            2 -> {
                                paint.color = Color.GREEN
                            }
                            3 -> {
                                paint.color = Color.BLACK
                            }
                        }

                        dialog.cancel()

                    })
                .show { }
        }

        binding.pen.setOnClickListener {

            val dialog = MaterialDialog(this)
                .title(text = "Choose Width")
                .listItemsSingleChoice(
                    items = listOf("10f", "14f", "16f", "32f"),
                    selection = { dialog, index, text ->

                        when (index) {
                            0 -> {
                                paint.strokeWidth = 10f
                            }
                            1 -> {
                                paint.strokeWidth = 14f
                            }
                            2 -> {
                                paint.strokeWidth = 16f
                            }
                            3 -> {
                                paint.strokeWidth = 32f
                            }
                        }

                        dialog.cancel()

                    })
                .show { }

        }

        binding.eraser.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
                .setTitle("Attention")
                .setMessage("You picked eraser")
                .show()

            paint.strokeWidth = 20f
            paint.color = Color.WHITE

        }


        binding.paintCanvas.setOnTouchListener { view, motionEvent ->

            when (motionEvent.action) {

                MotionEvent.ACTION_DOWN -> {

                    binding.paintCanvas.buildDrawingCache(true)
                    binding.paintCanvas.isDrawingCacheEnabled = true
                    bitmap = binding.paintCanvas.drawingCache
                    canvas = Canvas(bitmap!!)

                }

                MotionEvent.ACTION_MOVE -> {

                    if (startX == null && startY == null) {
                        startX = motionEvent.x
                        startY = motionEvent.y
                    }

                    canvas.drawLine(startX!!, startY!!, motionEvent.x, motionEvent.y, paint)

                    startX = motionEvent.x
                    startY = motionEvent.y

                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    startX = null
                    startY = null
                }

            }

            binding.paintCanvas.setImageBitmap(bitmap)

            true
        }

    }
}