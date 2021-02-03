package com.example.mysecondunitconverterapp

import android.annotation.SuppressLint
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
                @SuppressLint("SetTextI18n")
                fun convert() {

                    if (validationCheck()) {

                        val firstSelectedUnit = fromUnitSpinner.selectedItem.toString()    //setting the selected item from first-unit-spinner to variable
                        val secondSelectedUnit = toUnitSpinner.selectedItem.toString()    //setting the selected item from second-unit-spinner to variable
                        //.selectedItem - returns the data corresponding to current data item

                        var inputValue: Double = firstInputEditText.text.toString().toDouble()  //Extracting the input value from edit-text view.

                        when (quantitySpinner.selectedItem) {
                            "Weight" -> {
                                //.valueOf - This methods returns the enum constant defined in enum, matching the input string.
                                // If the constant, is not present in the enum, then an IllegalArgumentException is thrown.

                                val fromUnitSpinner = Weight.valueOf(firstSelectedUnit)
                                val secondSelectedUnit = Weight.valueOf(secondSelectedUnit)

                                if (secondSelectedUnit == Weight.Kilogram) {
                                    convertedTextView.setText(" ${fromUnitSpinner.kilogramConvert * inputValue} kilogram(s) ")
                                }
                                if (secondSelectedUnit == Weight.Gram) {
                                    convertedTextView.setText(" ${fromUnitSpinner.gramConvert * inputValue} gram(s) ")
                                }
                                if (secondSelectedUnit == Weight.Pound) {
                                    convertedTextView.setText(" ${fromUnitSpinner.poundConvert * inputValue} pound(s) ")
                                }
                                if (secondSelectedUnit == Weight.Ton) {
                                    convertedTextView.setText(" ${fromUnitSpinner.tonConvert * inputValue} ton(s)")
                                }
                            }

                            "Length" -> {

                                val fromUnitSpinner = Length.valueOf(firstSelectedUnit)
                                val secondSelectedUnit = Length.valueOf(secondSelectedUnit)

                                if (secondSelectedUnit == Length.Kilometer) {
                                    convertedTextView.setText(" ${fromUnitSpinner.kilometerConvert * inputValue} kilometer(s) ")
                                }
                                if (secondSelectedUnit == Length.Meter) {
                                    convertedTextView.setText(" ${fromUnitSpinner.meterConvert * inputValue} meter(s) ")
                                }
                                if (secondSelectedUnit == Length.Inch) {
                                    convertedTextView.setText(" ${fromUnitSpinner.inchConvert * inputValue} inch(s) ")
                                }
                                if (secondSelectedUnit == Length.Feet) {
                                    convertedTextView.setText(" ${fromUnitSpinner.feetConvert * inputValue} feet(s)")
                                }
                            }

                            "Volume" -> {
                                val fromUnitSpinner = Volume.valueOf(firstSelectedUnit)
                                val secondSelectedUnit = Volume.valueOf(secondSelectedUnit)

                                if (secondSelectedUnit == Volume.Liter) {
                                    convertedTextView.setText(" ${fromUnitSpinner.literConvert * inputValue} liter(s) ")
                                }
                                if (secondSelectedUnit == Volume.Milliliter) {
                                    convertedTextView.setText(" ${fromUnitSpinner.milliliterConvert * inputValue} milliliter(s) ")
                                }
                            }
                            }
                        }
                    }


                fun validationCheck() : Boolean {                //entry validation check method
                    var a = true
                    if(firstInputEditText.text.toString().trim().isEmpty()){
                        firstInputEditText.error = "Please Enter Initial Value"
                        a = false
                    }
                    else if (firstInputEditText.text.toString().matches("[A-Za-z*$%#&^()@!_+{}';]*".toRegex())){
                        firstInputEditText.error = "Wrong Input"
                        a = false
                    }
                    return a
                }
}






