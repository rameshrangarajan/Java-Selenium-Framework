package com.saf.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author raju.ganji
 * 
 */
public class DateTime {

	public String ymdhmsTime() throws Exception {
		String ymdhmsTime = null;
		DateFormat ymdhms = new SimpleDateFormat("HH-mm-ss_dd-MM-yy");
		Date date = new Date();
		ymdhmsTime = ymdhms.format(date);
		return (ymdhmsTime);
	}

	public String hmsTime() throws Exception {
		String hmsTime = null;
		DateFormat hms = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		hmsTime = hms.format(date);
		return (hmsTime);
	}

	public double timeDifference(String startTime, String endTime)
			throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date time1 = dateFormat.parse(startTime);
		Date time2 = dateFormat.parse(endTime);

		long t1 = time1.getTime();

		long t2 = time2.getTime();

		double diffTime = (Math.abs(t2 - t1) / 1000);
		return ((double) diffTime);
	}
	public String yyyyMMDDHHmmssTime() throws Exception {
		String ymdhmsTime = null;
		DateFormat ymdhms = new SimpleDateFormat("yyyyMMDDHHmmss");
		Date date = new Date();
		ymdhmsTime = ymdhms.format(date);
		return (ymdhmsTime);
	}
}
