/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//***************************************
//          Author tag
//Ishbir Walia-2015041
//****************************************

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
public class myTableArrest extends AbstractTableModel{
	private Object[][] data = new String[20][10];
	private String count;
	private int counting;
	private int xcounter;
	public myTableArrest(ArrayList<Arrest> dataset,int counterInp){
		xcounter = counterInp;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(Arrest k:dataset){
			data[counting][0] = k.CriminalID;
			data[counting][1] = k.Criminal_Name;
			data[counting][2] = k.Height;
			data[counting][3] = k.Weight;
			data[counting][4] = k.Age;
			data[counting][5] = k.House_Number;
			data[counting][6] = k.Street;
			data[counting][7] = k.City;
			data[counting][8] = k.Time;
			data[counting][9] = k.Date;
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Criminal ID", "Name", "Height","Weight", "Age","House NUmber","Street Name","City","Time","Date" };
	public int getColumnCount() {
		return columnNames.length;
	}
	public int getRowCount() {
	      return data.length;
	 }
	 public String getColumnName(int col) {
	      return columnNames[col];
	 }
	public Object getValueAt(int row, int col) {
	      return data[row][col];
	   }
	private void setCount(int s){
		count =  Integer.toString(s);
	}
}



