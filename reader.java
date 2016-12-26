
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Iterator;

public class reader
{

    public static void main(String[] args)
    {
        String fileName = "processes.txt";  //had trouble in this section, looked up help on github
        int quantum = 4 ;
        int clock = 0;
        int shorterTime = 0;
        int difference = 0;
        int initialTime = 0;
        int totalTime = 0;
        int contextCount = 0;
        int turnAround = 0; 
        int waitingTime = 0;
        int originalBurst = 0;
        int throughput = 0;
        
        Queue<ProcessCreation>readyQ = new LinkedList<ProcessCreation>();
        Queue<ProcessCreation>waitQ = new LinkedList<ProcessCreation>();
        Iterator waitCheck = waitQ.iterator();
        Iterator emptyCheckR = readyQ.iterator();
        Iterator emptyCheckW = waitQ.iterator();
        Queue<ProcessCreation>orderList = new LinkedList<ProcessCreation>();

        try {
            Scanner inputStream = new Scanner(new File(fileName));
            Queue<ProcessCreation> queue = new LinkedList <ProcessCreation>();
            while (inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                String[] ary = line.split(",");

                int pid = Integer.parseInt(ary[0]);
                int arrive = Integer.parseInt(ary[1]);
                int burst = Integer.parseInt(ary[2]);

                if(arrive == 0) {
                    readyQ.add(new ProcessCreation(pid,arrive,burst,0));

                }
                else {
                    waitQ.add(new ProcessCreation(pid,arrive,burst,0)); 
                }

            }
            inputStream.close();
        } 
        catch(FileNotFoundException exception) {

            System.out.println("The file " + fileName + " was not found.");

        }

        while(emptyCheckR.hasNext() || emptyCheckW.hasNext() ) {
            quantum = 4;
            ProcessCreation runningProcess;

            if (emptyCheckR.hasNext())
                runningProcess = readyQ.remove();
            else {
                runningProcess = waitQ.remove();
                clock = clock + runningProcess.getAt();

            }
            if( runningProcess.getBt() < quantum) {
                difference = quantum - runningProcess.getBt();
                shorterTime = quantum - difference;
                quantum = shorterTime;

            }
            originalBurst = runningProcess.getBt();
            runningProcess.setBt(runningProcess.getBt() - quantum);

            if(runningProcess.getBt() <= 0) {
                clock = clock + quantum;
                orderList.add(runningProcess);
                contextCount++;
                runningProcess.setCs(clock);
                System.out.println("Finish time of P" + runningProcess.getId() + " is " + runningProcess.getCs());
                
                turnAround = runningProcess.getCs() - runningProcess.getAt();
                System.out.println("Turnaround Time is: " + turnAround);
                
               
                waitingTime = turnAround - originalBurst;
                System.out.println("Waiting Time : " + waitingTime);
                throughput++;
                
            }

            else {
                clock = clock + quantum; 
                orderList.add(runningProcess);
                readyQ.add(runningProcess);

                contextCount++;

            }

            if (waitCheck.hasNext() ) 
            {
                ProcessCreation findAt = waitQ.peek();
                if  ( findAt.getAt() <= clock )
                {
                    readyQ.add(waitQ.remove());

                }

            }
        }

        //check for queue
        Iterator orderPrint = orderList.iterator();
        System.out.println("Order of Processes");
        while(orderPrint.hasNext())
        {
            ProcessCreation firstelement = orderList.remove();

            System.out.print(" P" + firstelement.getId());

        }
        totalTime = clock; 
        System.out.println("  ");
        System.out.println("Total runtime: " + clock);
        System.out.println("------");
        System.out.println("CPU Utilization: " + clock/totalTime*100 +"%");
        System.out.println("Amount of ContextSwitches: " + contextCount);
        System.out.println("Throughput: " + throughput); 
    }
}
