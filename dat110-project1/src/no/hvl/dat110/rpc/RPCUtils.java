package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[1 + str.getBytes().length];

		// TODO: marshall RPC identifier and string into byte array

		encoded[0] = rpcid;
		int i = 1;

		for (byte b : str.getBytes()) {
			encoded[i++] = b;
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded

		decoded = new String(data, 1, data.length - 1);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type

		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];

		// TODO: marshall RPC identifier and string into byte array

		encoded[0] = rpcid;
		
		byte[] intBuffer = ByteBuffer.allocate(4).putInt(x).array();
		
		int i = 1;
		
		for(byte b : intBuffer) {
			encoded[i++] = b;
		}
		
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		
		int decoded;
		
		// TODO: unmarshall integer contained in data
		
		decoded = ByteBuffer.wrap(data, 1, data.length - 1).getInt();
		
		return decoded;

	}
}
