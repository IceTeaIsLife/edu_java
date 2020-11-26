package Practice_19_20;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class ChatServer {
	private static int port = 8841;
	private static ArrayList<InetAddress> ipAddresses = new ArrayList<>();
	private static ArrayList<Integer> ports = new ArrayList<>();
	private static StringBuilder history = new StringBuilder();
	private static File file = new File("src/Practice_19_20/history.txt");

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(port);
		System.out.println("Chat server is on!\nPort: " + port + "\n");
		sendMessage(socket);
	}

	public static void sendMessage(DatagramSocket socket)
	{
		while (true)
		{
			byte[] buffer = new byte[2048];
			DatagramPacket packetToReceive = new DatagramPacket(
					buffer,
					0,
					buffer.length);
			try {
				socket.receive(packetToReceive);

				String message = new String(buffer, 0, packetToReceive.getLength());
				if (message.equals("jhhfthddgcbsvvtftyiujrvf"))
				{
					ipAddresses.add(packetToReceive.getAddress());
					ports.add(packetToReceive.getPort());
				}
				else {
					System.out.println(message);
					for (int i = 0; i < ports.size(); i++) {

						if (!((packetToReceive.getAddress().equals(ipAddresses.get(i))) && (packetToReceive.getPort() == ports.get(i)))) {
							byte[] data = message.getBytes();
							DatagramPacket packetToSend = new DatagramPacket(
									data,
									0, data.length,
									ipAddresses.get(i),
									ports.get(i)
							);
							socket.send(packetToSend);
						}
					}
					history.append(message + "\n");
					try (PrintWriter writerFile = new PrintWriter(file)) {
						writerFile.write(history.toString());
					} catch (IOException e) {
						e.getStackTrace();
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
