import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Math;

public class Server {

    private static Socket socket;
    public static void main(String[] args) {
        try {
            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println(String.format("Server Started and listening to the port %d",port));

            //Server is running always. This is done using this while(true) loop
            while (true) {
                socket = serverSocket.accept();
                //Reading the message from the client
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String command = br.readLine();
                System.out.println("New command received from client is " + command);

                String returnMessage;
                try {
                    String[] parts = command.split(" ");
                    double op1;
                    double op2;
                    double res;
                    double time;
                    long startTime;
                    long stopTime;
                    switch (parts[0]) {
                        case "add":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = op1+op2;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "subtract":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = op1-op2;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "divide":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = op1/op2;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "multiply":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = op1*op2;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "mod":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = op1%op2;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "pow":
                            op1 = Double.parseDouble(parts[1]);
                            op2 = Double.parseDouble(parts[2]);
                            startTime = System.nanoTime();
                            res = Math.pow(op1,op2);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "sin":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.sin(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "cos":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.cos(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "tan":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.tan(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "cot":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = 1/Math.tan(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "sinh":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.sinh(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "cosh":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.cosh(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "tanh":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.tanh(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "coth":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = 1/Math.tanh(op1*Math.PI/180);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "inv":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = 1/op1;
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "fact":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = 1;
                            for (int i=2; i <= (int)(op1); i++) {
                                res*=i;
                            }
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "log":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.log10(op1);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "exp":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.exp(op1);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "ln":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.log(op1);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        case "sqrt":
                            op1 = Double.parseDouble(parts[1]);
                            startTime = System.nanoTime();
                            res = Math.sqrt(op1);
                            stopTime = System.nanoTime();
                            time = stopTime - startTime;
                            break;
                        default:
                            res =0;
                            time =0;
                            break;
                    }
                    //int numberInIntFormat = Integer.parseInt(command);
                    //int returnValue = numberInIntFormat * 2;
                    //returnMessage = String.valueOf(returnValue) + "\n";
                    returnMessage = time + " " + res + "\n";
                } catch (NumberFormatException e) {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Something went wrong\n";
                }

                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                System.out.println("Message sent to the client is " + returnMessage);
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
}