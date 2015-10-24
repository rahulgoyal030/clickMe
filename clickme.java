import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

// git added


class MyFrame  implements ActionListener   // using swing
{ 
	 JFrame f,f2;
	 JLabel  image[]= new JLabel[10];
	 JButton button[]=new JButton[10];
	 JTextField t;
	 JLabel src,leftTime,result;
	 JTabbedPane  tp;
	 JButton  start ;
	 Timer time,time2;
	 int flag=0;
	 int randomNum=0,score=0;
	 int count=0,count1=0,left=45;

	 MyFrame() {
		f = new JFrame("ClickMe");
        f.setSize(620,750);
		f.setLayout(null);
		Container can = f.getContentPane();
		can.setBackground(Color.yellow);    // to change backgroung color of frame
		f.setBounds(270,1,620,750);

        int j=1,k=1; int x,y;
		for(int i=1;i<=9;i++)
		{
            x=120*k;  y=130*j;
			button[i]= new JButton();
			button[i].setBounds(x,y,80,25);
			f.add(button[i]);
			button[i].addActionListener(this);

			image[i]= new JLabel(new ImageIcon("pic.png"));  // background image 
			image[i].setBounds(x+10,y-75,60,75);
			f.add(image[i]);
			image[i].setVisible(false);

			k++;
			if(k>3)
			{
				k=1;
				j++;
             }


		}

		start = new JButton("START");
		start.setBounds(240,500,80,30);
		f.add(start);


		start.addActionListener(this);

		time = new Timer(45000,this);
		time.setRepeats(false);

	    time2= new Timer(2000,this);
	  //  time2.setRepeats(true);
        

		f2 = new JFrame("u lost");
        f2.setSize(300,350);
		f2.setLayout(null);
		f2.setVisible(false);
		f2.setBounds(250,150,400,400);

		src= new JLabel("score  " + score);
		src.setBounds(200,50,150,25);
		f.add(src);
		src.setFont(new Font("",Font.BOLD,25));


		leftTime = new JLabel("time "+ left);
        leftTime.setBounds(450,50,100,25);
        f.add(leftTime);
        leftTime.setFont(new Font("",Font.BOLD,25));



        result= new JLabel("you score  " + score);
		result.setBounds(50,50,300,40);
		f2.add(result);
		result.setFont(new Font("",Font.BOLD,30));




		

	
		f.setVisible(true);



	}
	public static void main(String[] args) {
		new MyFrame();
	}

	public  void actionPerformed( ActionEvent e)
	{  
       
        for(int i=1;i<=9;i++)
         {
         	image[i].setVisible(false);
         }
	
		if(e.getSource()==start)
		{
			time.start();
			time2.start();
			start.setVisible(false);

	   

		} 
		
		else if(e.getSource()==button[randomNum])
         {   
         	 count1++;
         	 image[randomNum].setVisible(false);
         	 score+=10;
         	 src.setText("score "+ score);
         	 //time.start();
   
        

      
        // time2.start();
         
        }

         if((e.getSource()==time2||e.getSource()==time)&&flag==0)
        {
             left--;   // setting counter

         if(flag==0)
         {	
		  Random rand = new Random();
          randomNum = rand.nextInt((9) + 1);

          if((randomNum<1&&randomNum>9)||randomNum==0)
         	randomNum=5;

         count++;

          image[randomNum].setVisible(true);

         
          leftTime.setText("Time "+left);
           

         }
       
        }

          if(count-count1>1&&flag==0)  
         {
         	
         	f.dispose();
         	f2.setVisible(true);
         	result.setText("you score  " + score);
         	flag=1;

         }

         

	}

	
}

