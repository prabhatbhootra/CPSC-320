All the files in the program can be compiled by typing in javac *.java in the terminal. Before running the program, an input file should be
created with the number of computers, the number of edges, triples of the two computers that communicated along with the time of communication,
the computer that a virus was introduced to along with the time when that happened and the computer and time to be checked each on a new line.

The tester needs to be run to check whether a certain computer was infected at a certain time. To run the tester along with the file of input
java Tester < filename.extension needs to be typed into the terminal, with the name of the file in place of filename and the file extension in 
place of extension. 

There are four classes to implement the algorithm. The node class creates nodes to represent each computer and the time of an incoming communication.
The linked list class implements a linked list of nodes, and represents each computer that a certain computer communicated with and the times
of the communications. The class digraph uses the linked list class to represent each computer and their communications as a bidirectional 
graph. Finally, the tester class creates a graph from the information in the input file and outputs whether a certain computer was infected 
at a given time. 
