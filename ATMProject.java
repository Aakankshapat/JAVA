// import javax.swing.*;
// import java.awt.*;
// import java.util.*;
// import java.text.SimpleDateFormat;

// // ================= ACCOUNT CLASS =================
// class Account {
//     int accNo;
//     String name;
//     int pin;
//     double balance;
//     ArrayList<String> history;

//     Account(int accNo, String name, int pin) {
//         this.accNo = accNo;
//         this.name = name;
//         this.pin = pin;
//         this.balance = 0;
//         this.history = new ArrayList<>();
//     }

//     void addTransaction(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
//         history.add(type + " ₹" + amount + " on " + time);
//     }
// }

// // ================= MAIN CLASS =================
// public class ATMProject {

//     static ArrayList<Account> accounts = new ArrayList<>();
//     static int accCounter = 1001;
//     static Account currentUser = null;
//     static int attempts = 3;

//     public static void main(String[] args) {
//         mainMenu();
//     }

//     // ================= COMMON FRAME =================
//     static JFrame createFrame(String title) {
//         JFrame frame = new JFrame(title);
//         frame.setSize(420, 320);
//         frame.setLayout(new GridBagLayout());
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         return frame;
//     }

//     // ================= FIND ACCOUNT =================
//     static Account findAccount(int accNo) {
//         for (Account acc : accounts) {
//             if (acc.accNo == accNo) {
//                 return acc;
//             }
//         }
//         return null;
//     }

//     // ================= RECEIPT =================
//     static void showReceipt(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

//         String receipt = "------ ATM RECEIPT ------\n"
//                 + "Account : " + currentUser.accNo + "\n"
//                 + "Name    : " + currentUser.name + "\n"
//                 + "Type    : " + type + "\n"
//                 + "Amount  : ₹" + amount + "\n"
//                 + "Balance : ₹" + currentUser.balance + "\n"
//                 + "Time    : " + time + "\n"
//                 + "-------------------------";

//         JOptionPane.showMessageDialog(null, receipt);
//     }

//     // ================= MAIN MENU =================
//     static void mainMenu() {
//         JFrame frame = createFrame("ATM System");

//         JButton createBtn = new JButton("Create Account");
//         JButton loginBtn = new JButton("Login");

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(15, 15, 15, 15);

//         gbc.gridy = 0;
//         frame.add(createBtn, gbc);

//         gbc.gridy = 1;
//         frame.add(loginBtn, gbc);

//         frame.setVisible(true);

//         createBtn.addActionListener(e -> {
//             frame.dispose();
//             createAccount();
//         });

//         loginBtn.addActionListener(e -> {
//             frame.dispose();
//             loginScreen();
//         });
//     }

//     // ================= CREATE ACCOUNT =================
//     static void createAccount() {
//         JFrame frame = createFrame("Create Account");

//         JTextField nameField = new JTextField(15);
//         JPasswordField pinField = new JPasswordField(15);
//         JButton submit = new JButton("Create");

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);

//         gbc.gridx = 0; gbc.gridy = 0;
//         frame.add(new JLabel("Name:"), gbc);

//         gbc.gridx = 1;
//         frame.add(nameField, gbc);

//         gbc.gridx = 0; gbc.gridy = 1;
//         frame.add(new JLabel("PIN:"), gbc);

//         gbc.gridx = 1;
//         frame.add(pinField, gbc);

//         gbc.gridx = 0; gbc.gridy = 2;
//         gbc.gridwidth = 2;
//         frame.add(submit, gbc);

//         frame.setVisible(true);

//         submit.addActionListener(e -> {
//             try {
//                 String name = nameField.getText().trim();
//                 String pinText = new String(pinField.getPassword());

//                 if (name.isEmpty() || pinText.length() < 4)
//                     throw new Exception();

//                 int pin = Integer.parseInt(pinText);

//                 Account acc = new Account(accCounter++, name, pin);
//                 accounts.add(acc);

//                 JOptionPane.showMessageDialog(frame,
//                         "Account Created!\nAccount No: " + acc.accNo);

//                 frame.dispose();
//                 mainMenu();

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame,
//                         "Invalid input! (PIN must be numeric & ≥ 4 digits)");
//             }
//         });
//     }

//     // ================= LOGIN =================
//     static void loginScreen() {
//         JFrame frame = createFrame("Login");

//         JTextField accField = new JTextField(15);
//         JPasswordField pinField = new JPasswordField(15);
//         JButton loginBtn = new JButton("Login");

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);

//         gbc.gridx = 0; gbc.gridy = 0;
//         frame.add(new JLabel("Account No:"), gbc);

//         gbc.gridx = 1;
//         frame.add(accField, gbc);

//         gbc.gridx = 0; gbc.gridy = 1;
//         frame.add(new JLabel("PIN:"), gbc);

//         gbc.gridx = 1;
//         frame.add(pinField, gbc);

//         gbc.gridx = 0; gbc.gridy = 2;
//         gbc.gridwidth = 2;
//         frame.add(loginBtn, gbc);

//         frame.setVisible(true);

//         loginBtn.addActionListener(e -> {
//             try {
//                 int accNo = Integer.parseInt(accField.getText());
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 currentUser = findAccount(accNo);

//                 if (currentUser == null) {
//                     JOptionPane.showMessageDialog(frame, "Account not found!");
//                     return;
//                 }

//                 if (pin == currentUser.pin) {
//                     attempts = 3;
//                     frame.dispose();
//                     userMenu();
//                 } else {
//                     attempts--;
//                     JOptionPane.showMessageDialog(frame,
//                             "Wrong PIN! Attempts left: " + attempts);

//                     if (attempts == 0) {
//                         frame.dispose();
//                         mainMenu();
//                     }
//                 }

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame,
//                         "Invalid input!");
//             }
//         });
//     }

//     // ================= USER MENU =================
//     static void userMenu() {
//         JFrame frame = createFrame("Welcome " + currentUser.name);

//         JButton deposit = new JButton("Deposit");
//         JButton withdraw = new JButton("Withdraw");
//         JButton balance = new JButton("Balance");
//         JButton history = new JButton("History");
//         JButton logout = new JButton("Logout");

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);

//         gbc.gridx = 0; gbc.gridy = 0;
//         frame.add(deposit, gbc);

//         gbc.gridx = 1;
//         frame.add(withdraw, gbc);

//         gbc.gridx = 0; gbc.gridy = 1;
//         frame.add(balance, gbc);

//         gbc.gridx = 1;
//         frame.add(history, gbc);

//         gbc.gridx = 0; gbc.gridy = 2;
//         gbc.gridwidth = 2;
//         frame.add(logout, gbc);

//         frame.setVisible(true);

//         // Deposit
//         deposit.addActionListener(e -> {
//             try {
//                 String input = JOptionPane.showInputDialog("Enter amount:");
//                 if (input == null) return;

//                 double amt = Double.parseDouble(input);

//                 if (amt <= 0) throw new Exception();

//                 currentUser.balance += amt;
//                 currentUser.addTransaction("Deposited", amt);
//                 showReceipt("Deposit", amt);

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid amount!");
//             }
//         });

//         // Withdraw
//         withdraw.addActionListener(e -> {
//             try {
//                 String input = JOptionPane.showInputDialog("Enter amount:");
//                 if (input == null) return;

//                 double amt = Double.parseDouble(input);

//                 if (amt <= 0 || amt > currentUser.balance)
//                     throw new Exception();

//                 currentUser.balance -= amt;
//                 currentUser.addTransaction("Withdrawn", amt);
//                 showReceipt("Withdraw", amt);

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame,
//                         "Invalid or insufficient balance!");
//             }
//         });

//         // Balance
//         balance.addActionListener(e -> {
//             JOptionPane.showMessageDialog(frame,
//                     "Balance: ₹" + currentUser.balance);
//         });

//         // History
//         history.addActionListener(e -> {
//             if (currentUser.history.isEmpty()) {
//                 JOptionPane.showMessageDialog(frame, "No transactions");
//                 return;
//             }

//             StringBuilder h = new StringBuilder();
//             for (String s : currentUser.history) {
//                 h.append(s).append("\n");
//             }

//             JOptionPane.showMessageDialog(frame, h.toString());
//         });

//         logout.addActionListener(e -> {
//             frame.dispose();
//             mainMenu();
//         });
//     }
// }


// import javax.swing.*;
// import java.awt.*;
// import java.util.*;
// import java.text.SimpleDateFormat;

// // ================= ACCOUNT CLASS =================
// class Account {
//     int accNo;
//     String name;
//     int pin;
//     double balance;
//     ArrayList<String> history;

//     Account(int accNo, String name, int pin) {
//         this.accNo = accNo;
//         this.name = name;
//         this.pin = pin;
//         this.balance = 0;
//         this.history = new ArrayList<>();
//     }

//     void addTransaction(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
//         history.add(type + " ₹" + amount + " on " + time);
//     }
// }

// // ================= MAIN CLASS =================
// public class ATMProject {

//     static ArrayList<Account> accounts = new ArrayList<>();
//     static int accCounter = 1001;
//     static Account currentUser = null;
//     static int attempts = 3;

//     public static void main(String[] args) {
//         UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
//         mainMenu();
//     }

//     // ================= COMMON FRAME =================
//     static JFrame createFrame(String title) {
//         JFrame frame = new JFrame(title);
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel panel = new JPanel();
//         panel.setBackground(new Color(30, 30, 60));
//         panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

//         frame.setContentPane(panel);
//         return frame;
//     }

//     // ================= STYLED BUTTON =================
//     static JButton styledButton(String text) {
//         JButton btn = new JButton(text);
//         btn.setFocusPainted(false);
//         btn.setBackground(new Color(70, 130, 180));
//         btn.setForeground(Color.WHITE);
//         btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         btn.setMaximumSize(new Dimension(200, 40));
//         return btn;
//     }

//     // ================= STYLED FIELD =================
//     static JTextField styledField() {
//         JTextField field = new JTextField();
//         field.setMaximumSize(new Dimension(200, 30));
//         return field;
//     }

//     // ================= FIND ACCOUNT =================
//     static Account findAccount(int accNo) {
//         for (Account acc : accounts) {
//             if (acc.accNo == accNo) return acc;
//         }
//         return null;
//     }

//     // ================= RECEIPT =================
//     static void showReceipt(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

//         String receipt = "------ ATM RECEIPT ------\n"
//                 + "Account : " + currentUser.accNo + "\n"
//                 + "Name    : " + currentUser.name + "\n"
//                 + "Type    : " + type + "\n"
//                 + "Amount  : ₹" + amount + "\n"
//                 + "Balance : ₹" + currentUser.balance + "\n"
//                 + "Time    : " + time + "\n"
//                 + "-------------------------";

//         JOptionPane.showMessageDialog(null, receipt);
//     }

//     // ================= MAIN MENU =================
//     static void mainMenu() {
//         JFrame frame = createFrame("ATM System");

//         JLabel title = new JLabel("ATM SYSTEM");
//         title.setFont(new Font("Segoe UI", Font.BOLD, 22));
//         title.setForeground(Color.WHITE);
//         title.setAlignmentX(Component.CENTER_ALIGNMENT);

//         JButton createBtn = styledButton("Create Account");
//         JButton loginBtn = styledButton("Login");

//         JPanel panel = (JPanel) frame.getContentPane();

//         panel.add(Box.createVerticalStrut(30));
//         panel.add(title);
//         panel.add(Box.createVerticalStrut(30));
//         panel.add(createBtn);
//         panel.add(Box.createVerticalStrut(15));
//         panel.add(loginBtn);

//         frame.setVisible(true);

//         createBtn.addActionListener(e -> {
//             frame.dispose();
//             createAccount();
//         });

//         loginBtn.addActionListener(e -> {
//             frame.dispose();
//             loginScreen();
//         });
//     }

//     // ================= CREATE ACCOUNT =================
//     static void createAccount() {
//         JFrame frame = createFrame("Create Account");

//         JTextField nameField = styledField();
//         JPasswordField pinField = new JPasswordField();
//         pinField.setMaximumSize(new Dimension(200, 30));

//         JButton submit = styledButton("Create");

//         JPanel panel = (JPanel) frame.getContentPane();

//         panel.add(Box.createVerticalStrut(20));
//         panel.add(new JLabel("Name"));
//         panel.add(nameField);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(new JLabel("PIN"));
//         panel.add(pinField);
//         panel.add(Box.createVerticalStrut(20));
//         panel.add(submit);

//         frame.setVisible(true);

//         submit.addActionListener(e -> {
//             try {
//                 String name = nameField.getText();
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 Account acc = new Account(accCounter++, name, pin);
//                 accounts.add(acc);

//                 JOptionPane.showMessageDialog(frame,
//                         "Account Created!\nAccount No: " + acc.accNo);

//                 frame.dispose();
//                 mainMenu();

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= LOGIN =================
//     static void loginScreen() {
//         JFrame frame = createFrame("Login");

//         JTextField accField = styledField();
//         JPasswordField pinField = new JPasswordField();
//         pinField.setMaximumSize(new Dimension(200, 30));

//         JButton loginBtn = styledButton("Login");

//         JPanel panel = (JPanel) frame.getContentPane();

//         panel.add(Box.createVerticalStrut(20));
//         panel.add(new JLabel("Account Number"));
//         panel.add(accField);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(new JLabel("PIN"));
//         panel.add(pinField);
//         panel.add(Box.createVerticalStrut(20));
//         panel.add(loginBtn);

//         frame.setVisible(true);

//         loginBtn.addActionListener(e -> {
//             try {
//                 int accNo = Integer.parseInt(accField.getText());
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 currentUser = findAccount(accNo);

//                 if (currentUser == null) {
//                     JOptionPane.showMessageDialog(frame, "Account not found!");
//                     return;
//                 }

//                 if (pin == currentUser.pin) {
//                     frame.dispose();
//                     userMenu();
//                 } else {
//                     attempts--;
//                     JOptionPane.showMessageDialog(frame,
//                             "Wrong PIN! Attempts left: " + attempts);

//                     if (attempts == 0) {
//                         frame.dispose();
//                         mainMenu();
//                     }
//                 }

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= USER MENU =================
//     static void userMenu() {
//         JFrame frame = createFrame("Welcome " + currentUser.name);

//         JButton deposit = styledButton("Deposit");
//         JButton withdraw = styledButton("Withdraw");
//         JButton balance = styledButton("Balance");
//         JButton history = styledButton("History");
//         JButton logout = styledButton("Logout");

//         JPanel panel = (JPanel) frame.getContentPane();

//         panel.add(Box.createVerticalStrut(20));
//         panel.add(deposit);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(withdraw);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(balance);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(history);
//         panel.add(Box.createVerticalStrut(10));
//         panel.add(logout);

//         frame.setVisible(true);

//         deposit.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);
//             currentUser.balance += amt;
//             currentUser.addTransaction("Deposited", amt);
//             showReceipt("Deposit", amt);
//         });

//         withdraw.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);

//             if (amt > currentUser.balance) {
//                 JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
//                 return;
//             }

//             currentUser.balance -= amt;
//             currentUser.addTransaction("Withdrawn", amt);
//             showReceipt("Withdraw", amt);
//         });

//         balance.addActionListener(e -> {
//             JOptionPane.showMessageDialog(frame,
//                     "Balance: ₹" + currentUser.balance);
//         });

//         history.addActionListener(e -> {
//             if (currentUser.history.isEmpty()) {
//                 JOptionPane.showMessageDialog(frame, "No transactions");
//                 return;
//             }

//             StringBuilder h = new StringBuilder();
//             for (String s : currentUser.history) {
//                 h.append(s).append("\n");
//             }

//             JOptionPane.showMessageDialog(frame, h.toString());
//         });

//         logout.addActionListener(e -> {
//             frame.dispose();
//             mainMenu();
//         });
//     }
// }



// import javax.swing.*;
// import java.awt.*;
// import java.util.*;
// import java.text.SimpleDateFormat;

// // ================= ACCOUNT CLASS =================
// class Account {
//     int accNo;
//     String name;
//     int pin;
//     double balance;
//     ArrayList<String> history;

//     Account(int accNo, String name, int pin) {
//         this.accNo = accNo;
//         this.name = name;
//         this.pin = pin;
//         this.balance = 0;
//         this.history = new ArrayList<>();
//     }

//     void addTransaction(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
//         history.add(type + " ₹" + amount + " on " + time);
//     }
// }

// // ================= MAIN CLASS =================
// public class ATMProject {

//     static ArrayList<Account> accounts = new ArrayList<>();
//     static int accCounter = 1001;
//     static Account currentUser = null;
//     static int attempts = 3;

//     public static void main(String[] args) {
//         mainMenu();
//     }

//     // ================= BACKGROUND =================
//     static JPanel createBackground(JFrame frame) {
//         JPanel bg = new JPanel(new GridBagLayout());
//         bg.setBackground(new Color(30, 30, 60));
//         frame.add(bg);
//         return bg;
//     }

//     // ================= SIMPLE BOX =================
//     static JPanel createBox() {
//         JPanel box = new JPanel();
//         box.setPreferredSize(new Dimension(260, 250));
//         box.setBackground(Color.WHITE);
//         box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
//         box.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
//         return box;
//     }

//     // ================= BUTTON STYLE =================
//     static void styleBtn(JButton btn) {
//         btn.setAlignmentX(Component.CENTER_ALIGNMENT);
//         btn.setMaximumSize(new Dimension(180, 35));
//         btn.setFocusPainted(false);
//         btn.setBackground(new Color(70,130,180));
//         btn.setForeground(Color.WHITE);
//         btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
//     }

//     // ================= FIND ACCOUNT =================
//     static Account findAccount(int accNo) {
//         for (Account acc : accounts) {
//             if (acc.accNo == acc.accNo) return acc;
//         }
//         return null;
//     }

//     // ================= RECEIPT =================
//     static void showReceipt(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

//         String receipt = "------ ATM RECEIPT ------\n"
//                 + "Account : " + currentUser.accNo + "\n"
//                 + "Name    : " + currentUser.name + "\n"
//                 + "Type    : " + type + "\n"
//                 + "Amount  : ₹" + amount + "\n"
//                 + "Balance : ₹" + currentUser.balance + "\n"
//                 + "Time    : " + time + "\n"
//                 + "-------------------------";

//         JOptionPane.showMessageDialog(null, receipt);
//     }

//     // ================= MAIN MENU =================
//     static void mainMenu() {
//         JFrame frame = new JFrame("ATM System");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel bg = createBackground(frame);
//         JPanel box = createBox();

//         JLabel title = new JLabel("ATM SYSTEM");
//         title.setFont(new Font("Segoe UI", Font.BOLD, 18));
//         title.setAlignmentX(Component.CENTER_ALIGNMENT);

//         JButton createBtn = new JButton("Create Account");
//         JButton loginBtn = new JButton("Login");

//         styleBtn(createBtn);
//         styleBtn(loginBtn);

//         box.add(Box.createVerticalStrut(20));
//         box.add(title);
//         box.add(Box.createVerticalStrut(20));
//         box.add(createBtn);
//         box.add(Box.createVerticalStrut(10));
//         box.add(loginBtn);

//         bg.add(box);
//         frame.setVisible(true);

//         createBtn.addActionListener(e -> {
//             frame.dispose();
//             createAccount();
//         });

//         loginBtn.addActionListener(e -> {
//             frame.dispose();
//             loginScreen();
//         });
//     }

//     // ================= CREATE ACCOUNT =================
//     static void createAccount() {
//         JFrame frame = new JFrame("Create Account");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);

//         JPanel bg = createBackground(frame);
//         JPanel box = createBox();

//         JTextField nameField = new JTextField();
//         JPasswordField pinField = new JPasswordField();

//         nameField.setMaximumSize(new Dimension(200,30));
//         pinField.setMaximumSize(new Dimension(200,30));

//         JButton submit = new JButton("Create");
//         styleBtn(submit);

//         box.add(new JLabel("Name"));
//         box.add(nameField);
//         box.add(Box.createVerticalStrut(10));
//         box.add(new JLabel("PIN"));
//         box.add(pinField);
//         box.add(Box.createVerticalStrut(15));
//         box.add(submit);

//         bg.add(box);
//         frame.setVisible(true);

//         submit.addActionListener(e -> {
//             try {
//                 String name = nameField.getText();
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 Account acc = new Account(accCounter++, name, pin);
//                 accounts.add(acc);

//                 JOptionPane.showMessageDialog(frame,
//                         "Account Created!\nAccount No: " + acc.accNo);

//                 frame.dispose();
//                 mainMenu();

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= LOGIN =================
//     static void loginScreen() {
//         JFrame frame = new JFrame("Login");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);

//         JPanel bg = createBackground(frame);
//         JPanel box = createBox();

//         JTextField accField = new JTextField();
//         JPasswordField pinField = new JPasswordField();

//         accField.setMaximumSize(new Dimension(200,30));
//         pinField.setMaximumSize(new Dimension(200,30));

//         JButton loginBtn = new JButton("Login");
//         styleBtn(loginBtn);

//         box.add(new JLabel("Account No"));
//         box.add(accField);
//         box.add(Box.createVerticalStrut(10));
//         box.add(new JLabel("PIN"));
//         box.add(pinField);
//         box.add(Box.createVerticalStrut(15));
//         box.add(loginBtn);

//         bg.add(box);
//         frame.setVisible(true);

//         loginBtn.addActionListener(e -> {
//             try {
//                 int accNo = Integer.parseInt(accField.getText());
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 currentUser = findAccount(accNo);

//                 if (currentUser == null) {
//                     JOptionPane.showMessageDialog(frame, "Account not found!");
//                     return;
//                 }

//                 if (pin == currentUser.pin) {
//                     frame.dispose();
//                     userMenu();
//                 } else {
//                     attempts--;
//                     JOptionPane.showMessageDialog(frame,
//                             "Wrong PIN! Attempts left: " + attempts);

//                     if (attempts == 0) {
//                         frame.dispose();
//                         mainMenu();
//                     }
//                 }

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= USER MENU =================
//     static void userMenu() {
//         JFrame frame = new JFrame("Welcome " + currentUser.name);
//         frame.setSize(450, 400);
//         frame.setLocationRelativeTo(null);

//         JPanel bg = createBackground(frame);
//         JPanel box = createBox();

//         JButton deposit = new JButton("Deposit");
//         JButton withdraw = new JButton("Withdraw");
//         JButton balance = new JButton("Balance");
//         JButton history = new JButton("History");
//         JButton logout = new JButton("Logout");

//         styleBtn(deposit);
//         styleBtn(withdraw);
//         styleBtn(balance);
//         styleBtn(history);
//         styleBtn(logout);

//         box.add(deposit);
//         box.add(Box.createVerticalStrut(10));
//         box.add(withdraw);
//         box.add(Box.createVerticalStrut(10));
//         box.add(balance);
//         box.add(Box.createVerticalStrut(10));
//         box.add(history);
//         box.add(Box.createVerticalStrut(10));
//         box.add(logout);

//         bg.add(box);
//         frame.setVisible(true);

//         deposit.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);
//             currentUser.balance += amt;
//             currentUser.addTransaction("Deposited", amt);
//             showReceipt("Deposit", amt);
//         });

//         withdraw.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);

//             if (amt > currentUser.balance) {
//                 JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
//                 return;
//             }

//             currentUser.balance -= amt;
//             currentUser.addTransaction("Withdrawn", amt);
//             showReceipt("Withdraw", amt);
//         });

//         balance.addActionListener(e ->
//                 JOptionPane.showMessageDialog(frame,
//                         "Balance: ₹" + currentUser.balance)
//         );

//         history.addActionListener(e -> {
//             if (currentUser.history.isEmpty()) {
//                 JOptionPane.showMessageDialog(frame, "No transactions");
//                 return;
//             }

//             StringBuilder h = new StringBuilder();
//             for (String s : currentUser.history) {
//                 h.append(s).append("\n");
//             }

//             JOptionPane.showMessageDialog(frame, h.toString());
//         });

//         logout.addActionListener(e -> {
//             frame.dispose();
//             mainMenu();
//         });
//     }
// }




// import javax.swing.*;
// import java.awt.*;
// import java.util.*;
// import java.text.SimpleDateFormat;

// // ================= ACCOUNT CLASS =================
// class Account {
//     int accNo;
//     String name;
//     int pin;
//     double balance;
//     ArrayList<String> history;

//     Account(int accNo, String name, int pin) {
//         this.accNo = accNo;
//         this.name = name;
//         this.pin = pin;
//         this.balance = 0;
//         this.history = new ArrayList<>();
//     }

//     void addTransaction(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
//         history.add(type + " ₹" + amount + " on " + time);
//     }
// }

// // ================= MAIN CLASS =================
// public class ATMProject {

//     static ArrayList<Account> accounts = new ArrayList<>();
//     static int accCounter = 1001;
//     static Account currentUser = null;
//     static int attempts = 3;

//     public static void main(String[] args) {
//         mainMenu();
//     }

//     // ================= CENTER PANEL =================
//     static JPanel createCenterPanel(JFrame frame) {
//         JPanel panel = new JPanel(new GridBagLayout());
//         frame.add(panel);
//         return panel;
//     }

//     // ================= BOX =================
//     static JPanel createBox() {
//         JPanel box = new JPanel();
//         box.setPreferredSize(new Dimension(260, 260));
//         box.setBackground(Color.WHITE);
//         box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
//         box.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//         return box;
//     }

//     // ================= BUTTON STYLE =================
//     static void styleBtn(JButton btn) {
//         btn.setAlignmentX(Component.CENTER_ALIGNMENT);
//         btn.setMaximumSize(new Dimension(180, 35));
//         btn.setFocusPainted(false);
//     }

//     // ================= CENTER ALIGN =================
//     static void center(JComponent c) {
//         c.setAlignmentX(Component.CENTER_ALIGNMENT);
//     }

//     // ================= FIND ACCOUNT =================
//     static Account findAccount(int accNo) {
//         for (Account acc : accounts) {
//             if (acc.accNo == accNo) return acc;
//         }
//         return null;
//     }

//     // ================= RECEIPT =================
//     static void showReceipt(String type, double amount) {
//         String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

//         String receipt = "------ ATM RECEIPT ------\n"
//                 + "Account : " + currentUser.accNo + "\n"
//                 + "Name    : " + currentUser.name + "\n"
//                 + "Type    : " + type + "\n"
//                 + "Amount  : ₹" + amount + "\n"
//                 + "Balance : ₹" + currentUser.balance + "\n"
//                 + "Time    : " + time + "\n"
//                 + "-------------------------";

//         JOptionPane.showMessageDialog(null, receipt);
//     }

//     // ================= MAIN MENU =================
//     static void mainMenu() {
//         JFrame frame = new JFrame("ATM System");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         JPanel center = createCenterPanel(frame);
//         JPanel box = createBox();

//         JLabel title = new JLabel("ATM SYSTEM");
//         title.setFont(new Font("Segoe UI", Font.BOLD, 18));
//         center(title);

//         JButton createBtn = new JButton("Create Account");
//         JButton loginBtn = new JButton("Login");

//         styleBtn(createBtn);
//         styleBtn(loginBtn);

//         box.add(Box.createVerticalStrut(20));
//         box.add(title);
//         box.add(Box.createVerticalStrut(20));
//         box.add(createBtn);
//         box.add(Box.createVerticalStrut(10));
//         box.add(loginBtn);

//         center.add(box);
//         frame.setVisible(true);

//         createBtn.addActionListener(e -> {
//             frame.dispose();
//             createAccount();
//         });

//         loginBtn.addActionListener(e -> {
//             frame.dispose();
//             loginScreen();
//         });
//     }

//     // ================= CREATE ACCOUNT =================
//     static void createAccount() {
//         JFrame frame = new JFrame("Create Account");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);

//         JPanel centerPanel = createCenterPanel(frame);
//         JPanel box = createBox();

//         JTextField nameField = new JTextField();
//         JPasswordField pinField = new JPasswordField();

//         nameField.setMaximumSize(new Dimension(200,30));
//         pinField.setMaximumSize(new Dimension(200,30));

//         center(nameField);
//         center(pinField);

//         JLabel nameLabel = new JLabel("Name");
//         JLabel pinLabel = new JLabel("PIN");

//         center(nameLabel);
//         center(pinLabel);

//         JButton submit = new JButton("Create");
//         styleBtn(submit);

//         box.add(Box.createVerticalStrut(15));
//         box.add(nameLabel);
//         box.add(Box.createVerticalStrut(5));
//         box.add(nameField);
//         box.add(Box.createVerticalStrut(10));
//         box.add(pinLabel);
//         box.add(Box.createVerticalStrut(5));
//         box.add(pinField);
//         box.add(Box.createVerticalStrut(15));
//         box.add(submit);

//         centerPanel.add(box);
//         frame.setVisible(true);

//         submit.addActionListener(e -> {
//             try {
//                 String name = nameField.getText();
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 Account acc = new Account(accCounter++, name, pin);
//                 accounts.add(acc);

//                 JOptionPane.showMessageDialog(frame,
//                         "Account Created!\nAccount No: " + acc.accNo);

//                 frame.dispose();
//                 mainMenu();

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= LOGIN =================
//     static void loginScreen() {
//         JFrame frame = new JFrame("Login");
//         frame.setSize(450, 350);
//         frame.setLocationRelativeTo(null);

//         JPanel centerPanel = createCenterPanel(frame);
//         JPanel box = createBox();

//         JTextField accField = new JTextField();
//         JPasswordField pinField = new JPasswordField();

//         accField.setMaximumSize(new Dimension(200,30));
//         pinField.setMaximumSize(new Dimension(200,30));

//         center(accField);
//         center(pinField);

//         JLabel accLabel = new JLabel("Account No");
//         JLabel pinLabel = new JLabel("PIN");

//         center(accLabel);
//         center(pinLabel);

//         JButton loginBtn = new JButton("Login");
//         styleBtn(loginBtn);

//         box.add(Box.createVerticalStrut(15));
//         box.add(accLabel);
//         box.add(Box.createVerticalStrut(5));
//         box.add(accField);
//         box.add(Box.createVerticalStrut(10));
//         box.add(pinLabel);
//         box.add(Box.createVerticalStrut(5));
//         box.add(pinField);
//         box.add(Box.createVerticalStrut(15));
//         box.add(loginBtn);

//         centerPanel.add(box);
//         frame.setVisible(true);

//         loginBtn.addActionListener(e -> {
//             try {
//                 int accNo = Integer.parseInt(accField.getText());
//                 int pin = Integer.parseInt(new String(pinField.getPassword()));

//                 currentUser = findAccount(accNo);

//                 if (currentUser == null) {
//                     JOptionPane.showMessageDialog(frame, "Account not found!");
//                     return;
//                 }

//                 if (pin == currentUser.pin) {
//                     frame.dispose();
//                     userMenu();
//                 } else {
//                     attempts--;
//                     JOptionPane.showMessageDialog(frame,
//                             "Wrong PIN! Attempts left: " + attempts);

//                     if (attempts == 0) {
//                         frame.dispose();
//                         mainMenu();
//                     }
//                 }

//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(frame, "Invalid input!");
//             }
//         });
//     }

//     // ================= USER MENU =================
//     static void userMenu() {
//         JFrame frame = new JFrame("Welcome " + currentUser.name);
//         frame.setSize(450, 400);
//         frame.setLocationRelativeTo(null);

//         JPanel centerPanel = createCenterPanel(frame);
//         JPanel box = createBox();

//         JButton deposit = new JButton("Deposit");
//         JButton withdraw = new JButton("Withdraw");
//         JButton balance = new JButton("Balance");
//         JButton history = new JButton("History");
//         JButton logout = new JButton("Logout");

//         styleBtn(deposit);
//         styleBtn(withdraw);
//         styleBtn(balance);
//         styleBtn(history);
//         styleBtn(logout);

//         box.add(deposit);
//         box.add(Box.createVerticalStrut(10));
//         box.add(withdraw);
//         box.add(Box.createVerticalStrut(10));
//         box.add(balance);
//         box.add(Box.createVerticalStrut(10));
//         box.add(history);
//         box.add(Box.createVerticalStrut(10));
//         box.add(logout);

//         centerPanel.add(box);
//         frame.setVisible(true);

//         deposit.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);
//             currentUser.balance += amt;
//             currentUser.addTransaction("Deposited", amt);
//             showReceipt("Deposit", amt);
//         });

//         withdraw.addActionListener(e -> {
//             String input = JOptionPane.showInputDialog("Enter amount:");
//             if (input == null) return;

//             double amt = Double.parseDouble(input);

//             if (amt > currentUser.balance) {
//                 JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
//                 return;
//             }

//             currentUser.balance -= amt;
//             currentUser.addTransaction("Withdrawn", amt);
//             showReceipt("Withdraw", amt);
//         });

//         balance.addActionListener(e ->
//                 JOptionPane.showMessageDialog(frame,
//                         "Balance: ₹" + currentUser.balance)
//         );

//         history.addActionListener(e -> {
//             if (currentUser.history.isEmpty()) {
//                 JOptionPane.showMessageDialog(frame, "No transactions");
//                 return;
//             }

//             StringBuilder h = new StringBuilder();
//             for (String s : currentUser.history) {
//                 h.append(s).append("\n");
//             }

//             JOptionPane.showMessageDialog(frame, h.toString());
//         });

//         logout.addActionListener(e -> {
//             frame.dispose();
//             mainMenu();
//         });
//     }
// }



import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;

// ================= ACCOUNT CLASS =================
class Account {
    int accNo;
    String name;
    int pin;
    double balance;
    ArrayList<String> history;

    Account(int accNo, String name, int pin) {
        this.accNo = accNo;
        this.name = name;
        this.pin = pin;
        this.balance = 0;
        this.history = new ArrayList<>();
    }

    void addTransaction(String type, double amount) {
        String time = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        history.add(type + " ₹" + amount + " on " + time);
    }
}

// ================= MAIN CLASS =================
public class ATMProject {

    static ArrayList<Account> accounts = new ArrayList<>();
    static int accCounter = 1001;
    static Account currentUser = null;
    static int attempts = 3;

    public static void main(String[] args) {
        mainMenu();
    }

    // ================= CENTER PANEL =================
    static JPanel createCenterPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        return panel;
    }

    // ================= BOX =================
    static JPanel createBox() {
        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(260, 260));
        box.setBackground(Color.WHITE);
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        return box;
    }

    // ================= BUTTON STYLE =================
    static void styleBtn(JButton btn) {
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(180, 35));
        btn.setFocusPainted(false);
    }

    // ================= CENTER ALIGN =================
    static void center(JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    // ================= FIND ACCOUNT =================
    static Account findAccount(int accNo) {
        for (Account acc : accounts) {
            if (acc.accNo == accNo) return acc;
        }
        return null;
    }

    // ================= RECEIPT =================
    static void showReceipt(String type, double amount) {
        String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

        String receipt = "------ ATM RECEIPT ------\n"
                + "Account : " + currentUser.accNo + "\n"
                + "Name    : " + currentUser.name + "\n"
                + "Type    : " + type + "\n"
                + "Amount  : ₹" + amount + "\n"
                + "Balance : ₹" + currentUser.balance + "\n"
                + "Time    : " + time + "\n"
                + "-------------------------";

        JOptionPane.showMessageDialog(null, receipt);
    }

    // ================= MAIN MENU =================
    static void mainMenu() {
        JFrame frame = new JFrame("ATM System");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel center = createCenterPanel(frame);
        JPanel box = createBox();

        JLabel title = new JLabel("ATM SYSTEM");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        center(title);

        JButton createBtn = new JButton("Create Account");
        JButton loginBtn = new JButton("Login");

        styleBtn(createBtn);
        styleBtn(loginBtn);

        box.add(Box.createVerticalStrut(20));
        box.add(title);
        box.add(Box.createVerticalStrut(20));
        box.add(createBtn);
        box.add(Box.createVerticalStrut(10));
        box.add(loginBtn);

        center.add(box);
        frame.setVisible(true);

        createBtn.addActionListener(e -> {
            frame.dispose();
            createAccount();
        });

        loginBtn.addActionListener(e -> {
            frame.dispose();
            loginScreen();
        });
    }

    // ================= CREATE ACCOUNT =================
    static void createAccount() {
        JFrame frame = new JFrame("Create Account");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);

        JPanel centerPanel = createCenterPanel(frame);
        JPanel box = createBox();

        JTextField nameField = new JTextField();
        JPasswordField pinField = new JPasswordField();

        nameField.setMaximumSize(new Dimension(200,30));
        pinField.setMaximumSize(new Dimension(200,30));

        center(nameField);
        center(pinField);

        JLabel nameLabel = new JLabel("Name");
        JLabel pinLabel = new JLabel("PIN");

        center(nameLabel);
        center(pinLabel);

        JButton submit = new JButton("Create");
        JButton backBtn = new JButton("Back"); // 🔥 added

        styleBtn(submit);
        styleBtn(backBtn);

        box.add(Box.createVerticalStrut(15));
        box.add(nameLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(nameField);
        box.add(Box.createVerticalStrut(10));
        box.add(pinLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(pinField);
        box.add(Box.createVerticalStrut(15));
        box.add(submit);
        box.add(Box.createVerticalStrut(10));
        box.add(backBtn);

        centerPanel.add(box);
        frame.setVisible(true);

        submit.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int pin = Integer.parseInt(new String(pinField.getPassword()));

                Account acc = new Account(accCounter++, name, pin);
                accounts.add(acc);

                JOptionPane.showMessageDialog(frame,
                        "Account Created!\nAccount No: " + acc.accNo);

                frame.dispose();
                mainMenu();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            mainMenu();
        });
    }

    // ================= LOGIN =================
    static void loginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);

        JPanel centerPanel = createCenterPanel(frame);
        JPanel box = createBox();

        JTextField accField = new JTextField();
        JPasswordField pinField = new JPasswordField();

        accField.setMaximumSize(new Dimension(200,30));
        pinField.setMaximumSize(new Dimension(200,30));

        center(accField);
        center(pinField);

        JLabel accLabel = new JLabel("Account No");
        JLabel pinLabel = new JLabel("PIN");

        center(accLabel);
        center(pinLabel);

        JButton loginBtn = new JButton("Login");
        JButton backBtn = new JButton("Back"); // 🔥 added

        styleBtn(loginBtn);
        styleBtn(backBtn);

        box.add(Box.createVerticalStrut(15));
        box.add(accLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(accField);
        box.add(Box.createVerticalStrut(10));
        box.add(pinLabel);
        box.add(Box.createVerticalStrut(5));
        box.add(pinField);
        box.add(Box.createVerticalStrut(15));
        box.add(loginBtn);
        box.add(Box.createVerticalStrut(10));
        box.add(backBtn);

        centerPanel.add(box);
        frame.setVisible(true);

        loginBtn.addActionListener(e -> {
            try {
                int accNo = Integer.parseInt(accField.getText());
                int pin = Integer.parseInt(new String(pinField.getPassword()));

                currentUser = findAccount(accNo);

                if (currentUser == null) {
                    JOptionPane.showMessageDialog(frame, "Account not found!");
                    return;
                }

                if (pin == currentUser.pin) {
                    frame.dispose();
                    userMenu();
                } else {
                    attempts--;
                    JOptionPane.showMessageDialog(frame,
                            "Wrong PIN! Attempts left: " + attempts);

                    if (attempts == 0) {
                        frame.dispose();
                        mainMenu();
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        backBtn.addActionListener(e -> {
            frame.dispose();
            mainMenu();
        });
    }

    // ================= USER MENU =================
    static void userMenu() {
        JFrame frame = new JFrame("Welcome " + currentUser.name);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);

        JPanel centerPanel = createCenterPanel(frame);
        JPanel box = createBox();

        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton balance = new JButton("Balance");
        JButton history = new JButton("History");
        JButton logout = new JButton("Logout");

        styleBtn(deposit);
        styleBtn(withdraw);
        styleBtn(balance);
        styleBtn(history);
        styleBtn(logout);

        box.add(deposit);
        box.add(Box.createVerticalStrut(10));
        box.add(withdraw);
        box.add(Box.createVerticalStrut(10));
        box.add(balance);
        box.add(Box.createVerticalStrut(10));
        box.add(history);
        box.add(Box.createVerticalStrut(10));
        box.add(logout);

        centerPanel.add(box);
        frame.setVisible(true);

        deposit.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter amount:");
            if (input == null) return;

            double amt = Double.parseDouble(input);
            currentUser.balance += amt;
            currentUser.addTransaction("Deposited", amt);
            showReceipt("Deposit", amt);
        });

        withdraw.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter amount:");
            if (input == null) return;

            double amt = Double.parseDouble(input);

            if (amt > currentUser.balance) {
                JOptionPane.showMessageDialog(frame, "Insufficient Balance!");
                return;
            }

            currentUser.balance -= amt;
            currentUser.addTransaction("Withdrawn", amt);
            showReceipt("Withdraw", amt);
        });

        balance.addActionListener(e ->
                JOptionPane.showMessageDialog(frame,
                        "Balance: ₹" + currentUser.balance)
        );

        history.addActionListener(e -> {
            if (currentUser.history.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No transactions");
                return;
            }

            StringBuilder h = new StringBuilder();
            for (String s : currentUser.history) {
                h.append(s).append("\n");
            }

            JOptionPane.showMessageDialog(frame, h.toString());
        });

        logout.addActionListener(e -> {
            frame.dispose();
            mainMenu();
        });
    }
}