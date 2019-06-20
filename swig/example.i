%module example 
/*
%inline%{
#include "example.h"
//double My_variable = 3.0;
%}
*/
%{#include "example.h"%}
%include "example.h"
//%include "../src/example.c"

