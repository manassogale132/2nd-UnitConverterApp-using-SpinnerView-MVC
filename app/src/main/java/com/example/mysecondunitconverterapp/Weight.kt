package com.example.mysecondunitconverterapp

enum class Weight(val kilogramConvert : Double , val gramConvert : Double , val poundConvert : Double , val tonConvert : Double){

    Kilogram(1.0 , 1000.0 , 2.20462 , 0.001 ),
    Gram(0.001 , 1.0 , 0.0022 , 0.000001 ),
    Pound(0.4535, 453.592, 1.0 , 0.0005),
    Ton(1000.0, 907184.74, 2000.0 , 1.0),

}