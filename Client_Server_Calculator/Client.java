import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client
{

    private static Socket socket;
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String command = "";
        while (!command.toLowerCase().equals("terminate")) {
            try {
                command = "";
                String sendMessage = "";
                String host = "localhost";
                int port = 25000;
                InetAddress address = InetAddress.getByName(host);
                socket = new Socket(address, port);

                //Send the message to the server
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                System.out.println("Please enter an operator or terminate to exit:");
                command += reader.next();
                sendMessage = command;
                switch (command.toLowerCase()) {
                    case "add":
                    case "subtract":
                    case "divide":
                    case "multiply":
                    case "mod":
                    case "pow":
                        double[] op = new double[2];
                        System.out.println("Enter first operand:");
                        op[0] = reader.nextDouble();
                        System.out.println("Enter second operand:");
                        op[1] = reader.nextDouble();
                        sendMessage += " "+op[0]+" "+op[1];
                        break;
                    case "sin":
                    case "cos":
                    case "tan":
                    case "cot":
                    case "sinh":
                    case "cosh":
                    case "tanh":
                    case "coth":
                    case "inv":
                    case "fact":
                    case "log":
                    case "exp":
                    case "ln":
                    case "sqrt":
                        System.out.println("Enter operand:");
                        sendMessage += " "+reader.nextDouble();
                        break;
                    default:
                        break;
                }
                sendMessage += "\n";
                bw.write(sendMessage);
                bw.flush();
                System.out.println("Message sent to the server : " + sendMessage);

                //Get the return message from the server
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String message = br.readLine();
                System.out.println("Message received from the server : " + message+"\n");
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                //Closing the socket
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}