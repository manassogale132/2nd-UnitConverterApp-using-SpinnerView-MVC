package com.example.mysecondunitconverterapp

enum class Length (val kilometerConvert : Double , val meterConvert : Double , val inchConvert : Double , val feetConvert : Double) {

    Kilometer(1.0 , 1000.0 , 39370.1 , 3280.84),
    Meter(0.001 , 1.0 , 39.3701 ,3.28084 ),
    Inch(2.54e-5 , 0.0254 , 1.0 , 0.0833333),
    Feet(0.0003048 , 0.3048 , 12.0 , 1.0),

}