/*
	Paste contents into Chrome's Console
	with CTRL+SHIFT+J (Windows) or OPTION+CMD+J (Mac)
	and press enter to show results
*/

const fib = (n) => {
	let prev = 1;
	let curr = 0, next = 0;
	for (let i = 0; i < n; i++) {
		next = prev + curr;
		prev = curr;
		curr = next;
	}
	return next;
}

for (let i = 0; i < 10; i++) {
	console.log(`${i}-th fibonacci number: ${fib(i)}`);
}