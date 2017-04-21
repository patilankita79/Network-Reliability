# Network-Reliability
Algorithmic aspects of telecommunication network project 3.  In this project, an algorithm is devised to study the dependence of network reliability on the reliability of individual links
<hr>
<h1>Project Description</h1>
Project 3
The theme of the project is to study experimentally how the network reliability depends on the individual link reliabilities, in the specific situation described below. <br>
Network topology: A complete undirected graph on n = 5 nodes. This means, every node is connected with every other one (parallel edges and selfloops are excluded in this graph). As a result, this graph has m = 10 edges, representing the links of the network.
Components that may fail: The links of the network may fail, the nodes are always up. The reliability of each link is p, the same for every link. The parameter p will take different values in the experiments.
Reliability configuration: The system is considered operational, if the network is connected.<br>
Specific tasks:
 <br>
1.	Create an algorithm to compute the network reliability in the abovedescribed situation, using the method of exhaustive enumeration (see in the Lecture Notes). Note that the high level description given in the notes is not enough, since you also have to specify how you actually want to find the details, such as how to generate the possible states, how to assign an up/down system condition to each, how to convert it into a reliability value, etc.
IMPORTANT: Finding algorithmic solutions for these details is part of the task!
Describe how your algorithm works. First briefly explain informally the ideas. Then provide pseudo code for the description of the algorithm, with sufficient comments to make them readable and understandable by a human. <br>
2.	Write a computer program that implements the algorithm. You mayuse any programming language under any operating system, this is entirely of your choice. Make sure, however, that your program is well structured to support finding potential errors (debugging), checking correctness or trying out algorithm changes. Explain how your program supports these goals. Include a section that tells how to run your program (this is usually called ReadMe file). <br>
3.	Run the program for different values of p. Let the parameter p run over the [0,1] interval, in steps of 0.05. Show graphically in a diagram how the obtained network reliability values depend on p.<br>
4.	Now fix the p parameter at p = 0.85, and do the following experiment. Among the 210 = 1024 possible combinations of component states pick k of the combinations randomly, and flip the corresponding system condition. That is, if the system was up, change it to down, if it was down, change it to up. This aims at modeling the situation when there is some random error in the system status evaluation. Show in a diagram, how the reliability of the system changes due to this alteration, by showing how the change depends on k, in the range k = 0,1,2,3,...,20. During this experiment keep the value of the parameter p fixed at p = 0.85. To reduce the effect of randomness, run several experiments and average them out, for each value of k.<br>
5.	Provide a short (1-2 paragraph) explanation why the obtained diagramslook the way they look. In other words, try to argue that they exhibit a reasonable behavior that one could intuitively expect, so the program is likely to work correctly. <br>
