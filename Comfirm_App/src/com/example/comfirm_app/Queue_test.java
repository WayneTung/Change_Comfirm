package com.example.comfirm_app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import android.util.Log;

public class Queue_test {
	int lenght;
	int rssi;
	int check;
	int state;
	int counter=0;
	int range;
	int condition;
	
	Queue_test(int check, int state,int range, int condition) {
		this.check = check;
		this.state = state;
		this.range = range;
		this.condition = condition;
	}

	Queue<Integer> qe = new LinkedList<Integer>();

	public boolean Queue_function(int new_rssi) {
		rssi = new_rssi;
		int i = 0;// �X��-�P�_60 3��
		boolean in_flag = false;
		qe.add(rssi);
		//Log.d("����", qe.size() + "");

		Iterator it = qe.iterator();
		if(counter<range)
			counter++;
		if(counter==range){
			it.next();
			it.remove();
		}
		while (it.hasNext()) {
			if (state == 0) {			//�s�u
				Integer iteratorValue = (Integer) it.next();
				if (iteratorValue >= check) {
					i = i + 1;
					if (i == condition) {
						in_flag = true;
					}
				}
			} else if (state == 1) {	//���_
				Integer iteratorValue = (Integer) it.next();
				if (iteratorValue <= check) {
					i = i + 1;
					if (i == 5) {
						in_flag = true;
					}
				}
			}
		}
		return in_flag;

	}

}
