import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 54341;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to chat server!");

            // Start the thread to receive messages from the server
            new Thread(new MessageReceiver(socket)).start();
            
            // PrintWriter to send messages to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // BufferedReader to read user input
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;

            System.out.println("Type your messages below:");
            while ((message = userInput.readLine()) != null) {
                out.println(message);  // Send message to server
            }

            // Close resources explicitly when done
            userInput.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

    static class MessageReceiver implements Runnable {
        private Socket socket;

        public MessageReceiver(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);  // Print received messages
                }
            } catch (IOException e) {
                System.err.println("Connection lost: " + e.getMessage());
            } finally {
                try {
                    socket.close();  // Close the socket when done
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }
}
