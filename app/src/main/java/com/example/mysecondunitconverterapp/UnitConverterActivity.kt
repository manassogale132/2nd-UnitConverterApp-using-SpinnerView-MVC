package com.example.mysecondunitconverterapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
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
                val options = when(quantitySpinner){
                    "Weight" -> {
                        ArrayAdapter.createFromResource(baseContext,R.array.WeightUnits,android.R.layout.simple_spinner_dropdown_item)
                    }
                    "Length" -> {
                        ArrayAdapter.createFromResource(baseContext,R.array.LengthUnits,android.R.layout.simple_spinner_dropdown_item)
                    }
                    "Volume" -> {
                        ArrayAdapter.createFromResource(baseContext,R.array.VolumeUnits,android.R.layout.simple_spinner_dropdown_item)
                    }
                    else -> null
                }
                fromUnitSpinner.adapter = options
                toUnitSpinner.adapter = options

                ///
            }
        }
    }
}