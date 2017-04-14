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
public class myTableCrime extends AbstractTableModel{
	private Object[][] data = new String[1000][7];
	private String count;
	private int counting;
	private int xcounter;
	public myTableCrime(ArrayList<Crime> dataset,int counterInp){
		xcounter = counterInp;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(Crime k:dataset){
			data[counting][0] = k.CrimeID;
			data[counting][1] = k.Crime_Time;
			data[counting][2] = k.Crime_Date;
			data[counting][3] = k.Type;
			data[counting][4] = k.House;
			data[counting][5] = k.Street;
			data[counting][6] = k.City;
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Crime ID", "Crime Time", "Crime Date","Type", "House NUmber","Street Name","City" };
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



