class Main {

    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }

doTowers(3, A B C); //START    
doTowers(2 A C B);  //line 4
doTowers(1 A B C);  //line 4
stack = (3 A B C, 2 A C B, 1 A B C);
//-> print 1 A B C  in line 1
pop(1, A B C);
stack = (3 A B C, 2 A C B);
//-> print 2 A C B  in line 5
doTowers(1 C A B); //line 6
stack = (3 A B C, 2 A C B, 1 C A B);
//-> print 1 C A B in line 1
pop(1 C A B);
pop(2 A C B);
stack = (3 A B C);
//-> print 3 A B C in line 5
doTowers(2 B A C);
stack = (3 A B C, 2 B A C);
doTowers(1 B C A);
stack = (3 A B C, 2 B A C, 1 B C A);
//-> print 1 B CA in line 1
pop(1 B C A);
stack = (3 A B C, 2 B A C);
//-> print 2 B A C in line 5
doTowers(1 A B C);
stack = (3 A B C, 2 B A C, 1 A B C);
//-> print 1 A B C in line 1
pop(1 A B C);
pop(2 B A C);
pop(3 A B C);


    public static void doTowers(int topN, char from, char inter, char to){
        if(topN == 1) {                                             //line 1
            System.out.println("Disk 1 from " + from + " to " + to);//line 2
        }
        else{                                                       //line 3
            doTowers(topN -1, from, to, inter);                     //line 4
            System.out.println("Disk " + topN + " from " + from + " to " + to); //line5
            doTowers(topN - 1, inter, from, to);                   //line6
        }
    }
}




3,4,3,4,1,2,5,6,3,4,1,2,5,6,1,2,5,6,1,2







Disk 1 from A to C   --> line 1
Disk 2 from A to B	 --> line 5
Disk 1 from C to B   --> line 1
Disk 3 from A to C   --> line 5
Disk 1 from B to A   --> line 1
Disk 2 from B to C   --> line 5
Disk 1 from A to C   --> line 1
