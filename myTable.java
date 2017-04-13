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
public class myTable extends AbstractTableModel{
	private Object[][] data = new String[20][8];
	private String count;
	private int counting;
	private int xcounter;
	public myTable(ArrayList<Criminal> dataset,int counterInp){
		xcounter = counterInp;
		counting = 0;
		setCount(xcounter);
		if(dataset != null){
		for(Criminal k:dataset){
			data[counting][0] = k.CriminalID;
			data[counting][1] = k.Criminal_Name;
			data[counting][2] = k.Height;
			data[counting][3] = k.Weight;
			data[counting][4] = k.Age;
			data[counting][5] = k.House_Number;
			data[counting][6] = k.Street;
			data[counting][7] = k.City;
			counting ++;
			xcounter++;
			setCount(xcounter);
		}
	}
	}
	private String[] columnNames = { "Criminal ID", "Name", "Height","Weight", "Age","House NUmber","Street Name","City" };
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



