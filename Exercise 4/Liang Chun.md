# Exercise 4
#### Liang Chun Wong (3037494)

## Exercise 4.3
### Algorithm
```
module fib(n: Integer) : Integer
	var prev, curr, fibn: Integer;
	prev := 1;
	curr := 0;
	fibn := 0;
	repeat n times
		fibn := prev + curr;
		prev := curr;
		curr := fibn;
	endrepeat;
	return fibn;
endmodule
```

### Specification
```
var	n, prev, curr, fibn : Integer
prev 	n >= 0, prev = 1, curr = 0, fibn = 0;
post 	fibn = fibonnaci(n)
reads 	-
changes	prev, curr, fibn
mem 	-
```

### Example
Please see `fib.js`
