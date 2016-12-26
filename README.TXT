
  README for EstebanGarcia RoundRobin project.

This Program was made to simulate RoundRobin CPU scheduling. I think this project has led me to better understand roundrobin scheduling and its
pros and cons.

One of the early issues i dealt with was how to go about adding 3element objects into a list. This stems from two issues, one was that my knowledge of java tools
was rusty, this project reminded me to also keep in mind i should practice more to not lose my coding skills. The second issue was that i wanted to make
the process-list in such a way that i could add on more things that were tied to the list if needed. I wanted this to be easy to add on to incase i needed to keep 
track of more than 3-elements in this list. My classmate helped me comeup with a method that could do just that.

My second issue was also found by a classmate, my program would not work with irregular arrival time. This was because i first seperated the 
list into two queues. One for arrival-time-zero processes, and one for non-zero arrival time processes. The issue stemmed from the fact that i was
subtracting quantum time always, and not accounting for when the processes finishes early. And also becuase my clock would only increase in quantum times, and 
sometimes the arrival time was too far away and the program finished without getting some yet-to-arrive processes.

My program simulates RoundRobin in a close manner, i like to think. The program accounts for when a process finished early. The program also accounts for
and also calculates other needed statistics(mainly related to clock time and other recorded time-based statistics). These are evident in the outputs of this
program.


Included are screenshots with different quantum times aswell as code screenshots

As the output tells, the quantum time is key in how many context switches are made and how often a program is 
interrupted.
