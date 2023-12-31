package UIFrame;

import controller.CustomerController;
import controller.EmployeeController;
import controller.LoginController;
import dao.impl.CustomerDAO;
import dao.impl.EmployeeDAO;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.CustomerModel;
import model.EmployeeModel;

/**
 *
 * @author ACER
 */
public class LoginUi extends javax.swing.JDialog {

    private EmployeeDAO edao = new EmployeeDAO();
    private CustomerDAO customerDao = new CustomerDAO();
    private LoginController myLogin = new LoginController(customerDao, edao);

    public LoginUi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        addListener();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password: ");

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogin.setText("Login");

        btnSignUp.setForeground(new java.awt.Color(42, 68, 241));
        btnSignUp.setText("Register now?");
        btnSignUp.setContentAreaFilled(false);

        txtUsername.setToolTipText("");

        javax.swing.GroupLayout LoginFormLayout = new javax.swing.GroupLayout(LoginForm);
        LoginForm.setLayout(LoginFormLayout);
        LoginFormLayout.setHorizontalGroup(
            LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LoginFormLayout.createSequentialGroup()
                        .addGroup(LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        LoginFormLayout.setVerticalGroup(
            LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFormLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnLogin)
                .addGap(29, 29, 29)
                .addComponent(btnSignUp)
                .addGap(23, 23, 23))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Login UI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addListener() {
        this.btnLogin.addActionListener((ActionEvent e) -> {
            doLogin();
        });
        this.btnSignUp.addActionListener((ActionEvent e) -> {
            doRegister();
        });
    }

    private void doLogin() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
//        String username = "Cust001";
//        String password = "1985-08-20";
        Object user = myLogin.login(username, password);

        if (user instanceof EmployeeModel) {
            // Employee logged in
            EmployeeModel employeeModel = (EmployeeModel) user;
            JOptionPane.showMessageDialog(rootPane, "Employee login success");

            //exchange UI frame
            this.dispose();
            EmployeeController employeeController = new EmployeeController(employeeModel);
            EmployeeTasksUI employeeTasks = new EmployeeTasksUI(employeeController, employeeModel);
            employeeTasks.setVisible(true);
        } else if (user instanceof CustomerModel) {
            // Customer logged in
            CustomerModel customerModel = (CustomerModel) user;
            JOptionPane.showMessageDialog(rootPane, "Customer login success ");

            //exchange UI frame
            this.dispose();
            CustomerController customerController = new CustomerController(customerModel);
            CustomerTasksUI customerTasks = new CustomerTasksUI(customerModel, customerController);
            customerTasks.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Username or password is not correc!t");
        }
    }

    private void doRegister() {
        this.dispose();
        Register register = new Register(null, true);
        register.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginForm;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
