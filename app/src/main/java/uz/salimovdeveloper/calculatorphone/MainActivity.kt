package uz.salimovdeveloper.calculatorphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear_number.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        nol.setOnClickListener {
            input.text = addInputText("0")
        }

        bir.setOnClickListener {
            input.text = addInputText("1")
        }

        ikki.setOnClickListener {
            input.text = addInputText("2")
        }

        uch.setOnClickListener {
            input.text = addInputText("3")
        }

        tort.setOnClickListener {
            input.text = addInputText("4")
        }

        besh.setOnClickListener {
            input.text = addInputText("5")
        }

        olti.setOnClickListener {
            input.text = addInputText("6")
        }

        yetti.setOnClickListener {
            input.text = addInputText("7")
        }

        sakkiz.setOnClickListener {
            input.text = addInputText("8")
        }

        toqqiz.setOnClickListener {
            input.text = addInputText("9")
        }

        nuqta.setOnClickListener {
            amalYoz(".")
        }

        bolish.setOnClickListener {
            amalYoz("÷")
        }

        kopaytirish.setOnClickListener {
            amalYoz("×")
        }

        ayiruv.setOnClickListener {
            amalYoz("-")
        }

        qoshish.setOnClickListener {
            amalYoz("+")
        }

        foiz.setOnClickListener {
            foiz()
        }

        teng.setOnClickListener {
            Javob()
        }

    }

    private fun amalYoz(amal:String){
        val display = input.text.toString()
        if (display.last() == '+' || display.last() == '-' || display.last() == '×' || display.last() == '÷' || display.last() == '.'  || display.last() == '%'){
            input.text = display.substring(0, display.length-1) + amal
        }else{
            input.text = display + amal
        }
    }

    private fun addInputText(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }

    private fun getInput(): String{

        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        expression = expression.replace(Regex("%"), "%")
        return expression

    }

    private fun Javob(){
        try {
            val expression = getInput()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                output.text = "Xato !!!"
                output.setTextColor(ContextCompat.getColor(this, R.color.simvol2_botton))
            }else {
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.simvol2_botton))
            }
        }catch (e: Exception){

        }
    }

    private fun foiz(){

        try {
            var number_ = input.text.toString().toInt().toFloat()
            var result_ = (number_ * 10) / 100
            output.text = result_.toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.simvol2_botton))
        }catch (e: Exception){

        }

    }
}