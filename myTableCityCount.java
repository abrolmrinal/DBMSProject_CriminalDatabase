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
public class myTableCityCount extends AbstractTableModel{
	private Object[][] data = new String[1000][2];
	private String count;
	private int counting;
	private int xcounter;
	public myTableCityCount(ArrayList<CityCount> dataset,int counterInp){
		xcounter = counterInp;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(CityCount k:dataset){
			data[counting][0] = k.City_Name;
			data[counting][1] = k.Count;
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Name", "Count" };
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



