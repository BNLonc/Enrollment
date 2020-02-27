In this repo are two distinct programs: Writer and Enrollment

Enrollment is the meat and potatoes of this repo's functionality.
How it works:
	It is composed of three core classes: Class, Lecture, Section. These are similar, but distinct, 
and are representations of courses, lectures for those courses, and discussion sections of those 
lectures. 

FileWriter is a companion to Enrollment
	FileWriter is a tool that encodes user input into a file that the Enrollment code can read.

compile and run are Bash scripts that automatically compile or execute code
compile:
	use `./compile e` to compile the Enrollment code
	use `./compile w` to compile the FileWriter code
	use no argument to compile both
run:
	the same arguments for e and w work for run
