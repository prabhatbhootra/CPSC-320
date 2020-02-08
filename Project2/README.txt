To extract the JAR file, any archiver software can be used to extract the contents to a folder. Then, navigate to the directory where the .java files are stored using any terminal and type in javac *.java to compile the files. To run the program, type in java Tester < filename.extension where filename is the name of the input file and extension is the extension of the input file. 

There are four classes used to implement the solution. 

1) Sequence.java uses a linked list to store the two sequences that an alignment needs to be created for. Java's linked list API is
   used here. 

2) The class similarityMatrix has a two-dimensional array to store the penalties of a mismatch between any two letters from A, C, G, 
   T. 

3) The class bestAlign uses a two-dimensional array called minCost to find the alignment of the two sequences that gives a minimum edit distance. It then uses a method called output to insert dashes into a sequence based on the solution found by the alignment method and prints the penalties of the alignment of the two sequences while returning the minimum edit distance. 

4) Finally, the Tester class takes the input from the input file and calls the methods in bestAlign to print out the correct alignment of the two sequences and the minimum edit distance.
