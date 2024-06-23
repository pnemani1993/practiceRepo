package main

import "fmt"

func main() {

	var x [5]float64
	x[0] = 10
	x[1] = 20
	x[2] = 30
	x[3] = 40
	x[4] = 50
	var total float64 = 0
	for _, value := range x {
		// i - the current position in the array and value is the same as x[i] and range followed by the variable we want to loop over.
		defer fmt.Println(value)
		total += value
	}
	defer fmt.Println(total)
}
