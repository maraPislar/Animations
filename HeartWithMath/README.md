# Heart Drawing using Math

There is a math formula which results in a heart-shaped graph.

This formula is:

x = 16sin^3(t)

y = 13cos(t) - 5cos(2t) - 2cos(3t) - cos(4t)

where t is defined on [0, 2pi).

To compile:

javac --module-path=**<path-to-javafx-sdk-11.0.2-lib>** --add-modules=ALL-MODULE-PATH Heart.java

To run:

java --module-path=**<path-to-javafx-sdk-11.0.2-lib>** --add-modules=ALL-MODULE-PATH Heart
