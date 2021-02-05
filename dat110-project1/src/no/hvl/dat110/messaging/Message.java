package no.hvl.dat110.messaging;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length <= 127)
			this.payload = payload;
		else
			this.payload = null;
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[128];

		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		encoded[0] = (byte) payload.length;

		for (int i = 1; i <= payload.length; i++) {
			encoded[i] = payload[i - 1];
		}

		return encoded;
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message
		payload = new byte[received[0]];
		
		for (int i = 0; i < received[0]; i++) {
			this.payload[i] = received[i + 1];
		}

	}
}
