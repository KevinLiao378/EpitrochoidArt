package cc.kevinliao.epitrochoidart.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * 根据随机的种子生成不同的<a href="http://mathworld.wolfram.com/Epitrochoid.html">外旋轮线</a>
 */
class EpitrochoidView : View {

    private var widthMeasureSpecSize: Int? = null
    private var heightMeasureSpecSize: Int? = null
    private val mPaint: Paint = Paint()
    private val r = Random()
    private var a = r.nextInt(141) + 80
    private var b = r.nextInt(141) + 80
    private var h = r.nextInt(41) + 40

    constructor(mContext: Context) : super(mContext)

    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {
        initPaint()
    }

    /**
     * 初始化画笔
     */
    private fun initPaint() {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.GREEN
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //  设置宽高一致
        widthMeasureSpecSize = View.MeasureSpec.getSize(widthMeasureSpec)
        heightMeasureSpecSize = View.MeasureSpec.getSize(heightMeasureSpec)
        val mLayoutSize = Math.min(widthMeasureSpecSize!!, heightMeasureSpecSize!!)
        setMeasuredDimension(mLayoutSize,mLayoutSize)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //  在中心绘制轨迹
        val stop_t = b* 2* PI
        val dt = 0.05F
        var t = 0F
        while (t <= stop_t) {
            val x = (a + b)* cos(t) - h* cos((a +b)* (t/b))
            val y = (a + b)* sin(t) - h* sin((a +b)* (t/b))
            canvas?.drawPoint(x + widthMeasureSpecSize!!.div(2), y + heightMeasureSpecSize!!.div(2), mPaint)
            t+= dt
        }
    }

    /**
     * 重新绘制
     */
    fun reDraw() {
        a = r.nextInt(121) + 80
        b = r.nextInt(41) + 60
        h = r.nextInt(31) + 60
        invalidate()
    }

}