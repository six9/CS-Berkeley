def cascade(n):
	if n<10:
		print(n)
	else:
		print(n)
		cascade(n//10)
		print(n)

def shrink(n):
	print(n)
	if n>=10:
		shrink(n//10)

def grow(n):
	if n<10:
		print(n)
	else:
		grow(n//10)
		print(n)

def inverse_cascade(n):
	grow(n)
	print(n)
	shrink(n)
