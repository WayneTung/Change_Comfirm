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
	Queue_test(int check, int state) {
		this.check = check;
		this.state = state;
	}

	Queue<Integer> qe = new LinkedList<Integer>();

	public boolean Queue_function(int new_rssi) {
		rssi = new_rssi;
		int i = 0;// 旗標-判斷60 3次
		boolean in_flag = false;
		qe.add(rssi);
		Log.d("長度", qe.size() + "");

		Iterator it = qe.iterator();
		if(counter<6)
			counter++;
		if(counter==6){
			it.next();
			it.remove();
		}
		while (it.hasNext()) {
			if (state == 0) {			//連線
				Integer iteratorValue = (Integer) it.next();
				if (iteratorValue >= check) {
					i = i + 1;
					if (i == 3) {
						in_flag = true;
					}
				}
			} else if (state == 1) {	//中斷
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
