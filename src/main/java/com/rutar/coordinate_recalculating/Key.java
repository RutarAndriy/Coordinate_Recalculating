package com.rutar.coordinate_recalculating;

import org.apfloat.*;

import static com.rutar.apfloat_point.ApfloatPoint.PRECISION;

// ............................................................................

public class Key {

private Apfloat[] keyFrom = new Apfloat[8];
private Apfloat[] keyTo   = new Apfloat[8];

///////////////////////////////////////////////////////////////////////////////

public Key (double[] keyFrom, double[] keyTo) {

if (keyFrom.length != keyTo.length) { fillEmptyValue();
                                      return; }

for (int z = 0; z < keyFrom.length; z++) {
    this.keyFrom[z] = new Apfloat(String.valueOf(keyFrom[z]), PRECISION);
    this.keyTo[z]   = new Apfloat(String.valueOf(keyTo[z]),   PRECISION);
}

fillEmptyValue();

}

///////////////////////////////////////////////////////////////////////////////

public Key (String[] keyFrom, String[] keyTo) {

if (keyFrom.length != keyTo.length) { fillEmptyValue();
                                      return; }

for (int z = 0; z < keyFrom.length; z++) {
    this.keyFrom[z] = new Apfloat(keyFrom[z], PRECISION);
    this.keyTo[z]   = new Apfloat(keyTo[z],   PRECISION);
}

fillEmptyValue();
 
}

///////////////////////////////////////////////////////////////////////////////

private void fillEmptyValue() {

for (int z = 0; z < keyFrom.length; z++) {
    if (keyFrom[z] == null) { keyFrom[z] = Apfloat.ZERO.precision(PRECISION); }
    if (keyTo[z]   == null) { keyTo[z]   = Apfloat.ZERO.precision(PRECISION); }
}
}

///////////////////////////////////////////////////////////////////////////////

@Override
public String toString() {
    
String temp = "|%s, %s| -> |%s, %s|";
    
String l1 = String.format(temp,
    keyFrom[0].toString(true), keyFrom[1].toString(true),
    keyTo[0].toString(true), keyTo[1].toString(true));

String l2 = String.format(temp,
    keyFrom[2].toString(true), keyFrom[3].toString(true),
    keyTo[2].toString(true), keyTo[3].toString(true));

String l3 = String.format(temp,
    keyFrom[4].toString(true), keyFrom[5].toString(true),
    keyTo[4].toString(true), keyTo[5].toString(true));

String l4 = String.format(temp,
    keyFrom[6].toString(true), keyFrom[7].toString(true),
    keyTo[6].toString(true), keyTo[7].toString(true));

return String.format("%s\n%s\n%s\n%s", l1, l2, l3, l4);

}

///////////////////////////////////////////////////////////////////////////////

}