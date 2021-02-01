package com.example.mysecondunitconverterapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_unit_converter.*


class UnitConverterActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_converter)

        quantitySpinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{    //anonymous class

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
//An AdapterView is a ViewGroup that gets its child views from an Adapter.
// An Adapter is responsible for creating and binding data to views. An Adapter isn't an actual view, but instead produces them.

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(this@UnitConverterActivity,
                        "You selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()

                var quantitySpinner = resources.getStringArray(R.array.Quantity)[position]
                val options = when (quantitySpinner) {
                    "Weight" -> {
                        ArrayAdapter.createFromResource(baseContext, R.array.WeightUnits, android.R.layout.simple_spinner_dropdown_item)
                    }
                    "Length" -> {
                        ArrayAdapter.createFromResource(baseContext, R.array.LengthUnits, android.R.layout.simple_spinner_dropdown_item)
                    }
                    "Volume" -> {
                        ArrayAdapter.createFromResource(baseContext, R.array.VolumeUnits, android.R.layout.simple_spinner_dropdown_item)
                    }
                    else -> null
                }
                fromUnitSpinner.adapter = options
                toUnitSpinner.adapter = options
            }
        }

        convertBtn.setOnClickListener {           //using .setOnClickListener on the convert button and passing method in body
            convert()
        }

    }

                fun convert(){

                    val firstSelectedUnit = fromUnitSpinner.selectedItem.toString()    //setting the selected item from first-unit-spinner to variable
                    val secondSelectedUnit  = toUnitSpinner.selectedItem.toString()    //setting the selected item from second-unit-spinner to variable
                                                                                      //.selectedItem - returns the data corresponding to current data item

                    var inputValue : Double = firstInputEditText.text.toString().toDouble()  //Extracting the input value from edit-text view.

                    when(quantitySpinner.selectedItem){
                        "Weight" -> {
                           val fromUnitSpinner = Weight.valueOf(firstSelectedUnit)   //.valueOf - Returns the enum constant of this type with the specified name.
                            when(Weight.valueOf(secondSelectedUnit)) {
                                Weight.Kilogram -> convertedTextView.setText(" ${inputValue * fromUnitSpinner.kilogramConvert} kilogram(s) ")
                                Weight.Gram -> convertedTextView.setText(" ${inputValue * fromUnitSpinner.gramConvert} gram(s) ")
                                Weight.Pound -> convertedTextView.setText(" ${inputValue * fromUnitSpinner.poundConvert} pound(s) ")
                                Weight.Ton -> convertedTextView.setText(" ${inputValue * fromUnitSpinner.tonConvert} ton(s)")
                            }
                        }
                    }
                }
}






