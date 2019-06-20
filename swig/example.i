%module example 
/*
%inline%{
#include "example.h"
//double My_variable = 3.0;
%}
*/
%{
//double My_variable = 3.0;
#include "../src/example.c"
%}
%include "example.h"
//%include "../src/example.c"
%inline%{extern double My_variable;%}
