package com.sohang.trade.service;

public class Utils {

	public static double roundTo2Decimal(final Double d) {
		return (null == d) ? 0d : Math.round(d * 100.0d) / 100.0d;
	}

	public static float roundTo2Decimal(final Float f) {
		return (null == f) ? 0f : Math.round(f * 100.0f) / 100.0f;
	}

	public static float roundTo0Decimal(final Float f) {
		return (null == f) ? 0f : Math.round(f * 1.0f) / 1.0f;
	}
}
