package Practice_19_20;

import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
	private static int port = 8841;
	private static String nickname;
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			System.out.println("Type in your nickname:");
			nickname = (new Scanner(System.in)).nextLine();
			connectToServer(socket);
			Thread messageIn = new Thread(() -> receiveMessage(socket));
			messageIn.start();
			Thread messageOut = new Thread(() -> sendMessage(socket));
			messageOut.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void connectToServer(DatagramSocket socket)
	{
		String message = "jhhfthddgcbsvvtftyiujrvf";
		byte[] data = message.getBytes();
		try {
			DatagramPacket packet = new DatagramPacket(
					data,
					0, data.length,
					InetAddress.getByName("127.0.0.1"),
					port
			);
			socket.send(packet);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void sendMessage(DatagramSocket socket) {
		while (true) {
			Scanner in = new Scanner(System.in);
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String message = in.nextLine();
			message = format.format(date) + " | "  + nickname + ": " + message;
			byte[] data = message.getBytes();
			try {
				DatagramPacket packet = new DatagramPacket(
						data,
						0, data.length,
						InetAddress.getByName("127.0.0.1"),
						port
				);
				socket.send(packet);
			} catch (IOException e)
			{
				e.printStackTrace();//
			}
		}
	}

	public static void receiveMessage(DatagramSocket socket) {
		while (true)
		{
			byte[] buffer = new byte[2048];
			DatagramPacket packetToReceive = new DatagramPacket(
					buffer,
					0,
					buffer.length);
			try {
				socket.receive(packetToReceive);
				System.out.println(new String(packetToReceive.getData(), 0, packetToReceive.getLength()));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
