package UIFrame.DialogTasks;

import UIFrame.CustomerTasksUI;
import controller.CustomerController;
import java.util.List;
import javax.swing.JOptionPane;
import model.CustomerModel;
import model.LoanModel;

/**
 *
 * @author ACER
 */
public class NewLoanDialog extends javax.swing.JDialog {

    private CustomerController customerController;
    private CustomerTasksUI customerUI;
    private CustomerModel customer;

    /**
     * Creates new form NewCurrentAccountUI
     *
     * @param customerUI
     * @param modal
     * @param customerController
     * @param customer
     */
    public NewLoanDialog(CustomerTasksUI customerUI, boolean modal, CustomerController customerController, CustomerModel customer) {
        super(customerUI, modal);
        this.customerController = customerController;
        this.customerUI = customerUI;
        this.customer = customer;

        initComponents();
        onLoadCityBranch();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbxBranch = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Branch:");

        cmbxBranch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbxBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("$");

        txtBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCreate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Amount:");

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setText("Create New Loan");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel7))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(35, 35, 35)
                                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbxBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(profilePanelLayout.createSequentialGroup()
                                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))))
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreate)))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(61, 61, 61)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbxBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnBack))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        customerUI.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            String balanceText = this.txtBalance.getText();

            if (balanceText == null || (Double.parseDouble(balanceText) < 500 || Double.parseDouble(balanceText) > 1000)) {
                JOptionPane.showMessageDialog(rootPane, "Sorry, our minimum loan is $500 and maximum is $1000");
            } else {
                LoanModel loanModel = new LoanModel();
                loanModel.setLoanAmount((float) Double.parseDouble(balanceText));

                loanModel.setBranch_id(customerController.findBranchIDByCity((String) this.cmbxBranch.getSelectedItem()));

                customerController.saveLoan(loanModel, customer.getCustomer_id());
                JOptionPane.showMessageDialog(rootPane, "Create account successful");
                this.dispose();
                customerUI.setVisible(true);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Invalid input! Please enter a valid number.");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    public final void onLoadCityBranch() {

        cmbxBranch.removeAllItems();

        List<String> branchCities = customerController.selectBranch();

        for (String branchCity : branchCities) {
            cmbxBranch.addItem(branchCity);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> cmbxBranch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JTextField txtBalance;
    // End of variables declaration//GEN-END:variables
}
