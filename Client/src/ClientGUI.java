import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;




public class ClientGUI implements ActionListener {

    private  JTextArea chatArea;
    private  JLabel label ;
    private  JLabel loginLabel;
    private  JButton send ;
    private  JButton logout;
    private  JButton login;
    private  JTextField message;
    private  JTextField username;

    private  JList<String> friendsList;

    private Socket clientToServer;

    private PrintWriter out;
    private BufferedReader in;


    private boolean loggedIn=false;
    private String name;

    public ClientGUI(){
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 400);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        message = new JTextField(40);
        loginLabel = new JLabel("Enter Username");
        username = new JTextField(10);
        send = new JButton("Send");
        login= new JButton("Login");
        logout = new JButton("Logout");

        login.addActionListener(this);
        logout.addActionListener(this);
        send.addActionListener(this);

        //adding components to panel
        panel.add(label);
        panel.add(message);
        panel.add(send);
        panel.add(loginLabel);
        panel.add(username);
        panel.add(login);
        panel.add(logout);

        String[] userList;
        JPanel friendsPanel = new JPanel();
        friendsList = new JList<>();

        friendsPanel.add(friendsList);

        JPanel chatPanel=new JPanel();

        // chat Area at the Center
        chatArea = new JTextArea();

        chatPanel.add(chatArea);

        //Adding Components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.WEST, chatPanel);
        frame.getContentPane().add(BorderLayout.EAST, friendsPanel);
        frame.setVisible(true);

    }

    public void insertChatArea(Message m){
        chatArea.append("\n");
        chatArea.append(m.toChatString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login && !loggedIn){

        }
        else if (e.getSource()==login && loggedIn){
            username.setText("You are already logged in!");
        }
        else if(e.getSource() == send && loggedIn){

        }
        else if (e.getSource() == send && !loggedIn){
            message.setText("U moet eerst inloggen");
        }
        else if (e.getSource() == logout && loggedIn){

        }
    }

    public void setUserList(String userLijst) {
        String[] lijst = userLijst.split("/");
        friendsList.setListData(lijst);
    }

    public void setname(String string){
        name=string;
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(JLabel loginLabel) {
        this.loginLabel = loginLabel;
    }

    public JButton getSend() {
        return send;
    }

    public void setSend(JButton send) {
        this.send = send;
    }

    public JButton getLogout() {
        return logout;
    }

    public void setLogout(JButton logout) {
        this.logout = logout;
    }

    public JButton getLogin() {
        return login;
    }

    public void setLogin(JButton login) {
        this.login = login;
    }

    public JTextField getMessage() {
        return message;
    }

    public void setMessage(JTextField message) {
        this.message = message;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public Socket getClientToServer() {
        return clientToServer;
    }

    public void setClientToServer(Socket clientToServer) {
        this.clientToServer = clientToServer;
    }



    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
