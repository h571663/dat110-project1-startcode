package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	@Override
	public byte[] invoke(byte[] request) {

		byte[] reply;
		byte rpcid;

		// TODO:
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done in the SensorImpl for the read method
		rpcid = request[0];

		write(RPCUtils.unmarshallString(request));
		
		reply = RPCUtils.marshallVoid(rpcid);

		return reply;
	}
}
