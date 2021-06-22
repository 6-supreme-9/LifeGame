package UI;
import data.map;
import service.Logic;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ui extends JFrame {
	
	JPanel panel;
	JLabel lblNewLabel ;
	JLabel lblNewLabel_1 ;
	JPanel panel_1 ;
	
	private JLabel lblNewLabel_2;
	private JTextField tFRow;
	private JLabel lblNewLabel_3;
	private JTextField tFCol;
	private JButton btnNewButton;
//	private boolean flag = true;
	private int rows;
	private int cols;
	private Logic logic;
	private int generation = 0;
	Timer timer =new Timer(true);
	
	private class Button extends JButton{
		int row;
		int col;
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}
		
		public void setRow(int row) {
			this.row = row;
		}
		public void setCol(int col) {
			this.col = col;
		}
	}
	
	private Button[][] btns;//定义一个button的二位数组
	
	
	 public void setRowCol(int rows,int cols) {
			this.rows = rows;
			this.cols = cols;
	}
	 
	 public Ui() {}
	 
		public void initGUI() 
		{
			setTitle("\u751F\u547D\u6E38\u620F");

			setLocation(500, 200);
			setSize(964, 574);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			panel = new JPanel();
			
			lblNewLabel = new JLabel("\u7E41\u884D\u6B21\u6570\uFF1A");
			
			lblNewLabel_1 = new JLabel("N");
			
			lblNewLabel_2 = new JLabel("\u884C\u6570\uFF1A");
			
			tFRow = new JTextField();
			tFRow.setColumns(10);
			
			lblNewLabel_3 = new JLabel("\u5217\u6570\uFF1A");
			
			tFCol = new JTextField();
			tFCol.setColumns(10);
			
			btnNewButton = new JButton("\u786E\u8BA4");
			
		
			
		
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        timer.cancel();//终止当前的任务
			        timer.purge();
			        setVisible(false);
					
			        Ui ui = new Ui();
			        ui.initGUI();
			        ui.setRowCol(Integer.parseInt(tFRow.getText()),Integer.parseInt(tFCol.getText()));
					ui.init();
				}
			});
			
			
			
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tFRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblNewLabel_3)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tFCol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(82)
						.addComponent(btnNewButton)
						.addGap(136)
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(315, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(tFRow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_3)
							.addComponent(tFCol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton)
							.addComponent(lblNewLabel_1)
							.addComponent(lblNewLabel))
						.addContainerGap(26, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			
			 panel_1 = new JPanel();
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 950, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			getContentPane().setLayout(groupLayout);
			
			
		}
		
		
		
		
		
		
	public void init() 
	{
		
	
		initView();
		
	
		TimerTask task = new TimerTask()
				{
			public void run() 
			{
				
				logic.Count(rows,cols);
				logic.Generate(rows,cols);
				++generation;
				lblNewLabel_1.setText(""+generation);
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) 
					{
						if(logic.GetCell(i, j) ==1)
						{
							btns[i][j].setBackground(Color.black);
						
						}
						 else {
								btns[i][j].setBackground(Color.white);
							}
					}
				}
				
			}
				};
				
		timer.schedule(task,0,500);
		setVisible(true);
		
	}

	public void initView() {
		panel_1.setLayout(new GridLayout(rows, cols));
		btns = new Button[rows][cols];
		
		logic= null;
		System.gc();
		
		logic = new Logic();
		logic.Release();//释放内存
		logic.Start(rows,cols);
		
		generation = 1;
		initButtons(btns);
		
	}
	
	public void initButtons(Button[][] btns)
	{
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++) {
				btns[i][j] = new Button();
				btns[i][j].setRow(i);
				btns[i][j].setCol(j);
				
				btns[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int row1 = ((Button)e.getSource()).getRow();
						int col1 = ((Button)e.getSource()).getCol();
						logic.SetCell(row1, col1,1);
						((Button)e.getSource()).setBackground(Color.black);
					}
				});
				
				
				btns[i][j].setMargin(new Insets(0, 0, 0, 0)); //画网格线
				
				if(logic.GetCell(i, j) ==1)
				{
					btns[i][j].setBackground(Color.black);
					panel_1.add(btns[i][j]);
				}
				 else {
						btns[i][j].setBackground(Color.white);
						panel_1.add(btns[i][j]);
						}
			}
	}



	
	public static void main(String args[]) {
	  Ui ui= new Ui();
	  ui.initGUI();
	  ui.setRowCol(20, 20);
	  ui.init();
	}
	
}

