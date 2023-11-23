package com.mycompany.fees_managmentsystem;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class signup_page extends javax.swing.JFrame {
 
 int id =0;
public int getId(){
     ResultSet rs = null;
     try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url ="jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
      Connection con =DriverManager.getConnection(url, "root", "asdf123"); 
      String sql = "select max(id) from signup";
      Statement st = con.createStatement();
      rs =st.executeQuery(sql);
      while(rs.next()){
         
          id = rs.getInt(1);
           id++;
      }
 }
      catch(ClassNotFoundException | SQLException e)
    {
         e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
   return id;
 }
//        connection database
 void insertData(){
     SimpleDateFormat s1 = new SimpleDateFormat ("yyyy-MM-dd");
     String dob1 = s1.format(dob);
     try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url ="jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
      Connection con =DriverManager.getConnection(url, "root", "asdf123");
      String sql = "insert into signup values (?,?,?,?,?,?,?)";
      PreparedStatement st = con.prepareStatement(sql);
      
      
      st.setInt(1, getId());
      st.setString(2, fname);
      st.setString(3, lname);
      st.setString(4, uname);
      st.setString(5, pass);
      st.setString(6, dob1);
      st.setString(7, con_no);
    int i = st.executeUpdate();
    if (i>0)
    {
       JOptionPane.showMessageDialog(this , "Record Inserted Succesfully");
    }
    else
    {
          JOptionPane.showMessageDialog(this , "Record Not Inserted Succesfully","Warning",JOptionPane.WARNING_MESSAGE);

    }
    }
     catch(HeadlessException | ClassNotFoundException | SQLException e)
    {
         e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
    
}
String fname,lname,uname,pass,cpass,con_no;
        Date dob;
    public signup_page() {
        initComponents();
        
//        setIconImage();
        this.setTitle("Signup Page");
       }
    
    boolean validation()
    {
        
        fname = txt_firstname.getText();
        lname = txt_lastname.getText();
        uname = txt_username.getText();
        pass = txt_password.getText();
        cpass = txt_conpassword.getText();
        con_no = txt_contact.getText();
        dob = txt_dob.getDate();
        
        if( fname.equals("")){
            JOptionPane.showMessageDialog(this , "please enter FirstName","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if( lname.equals("")){
            JOptionPane.showMessageDialog(this , "please enter LastName","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if( uname.equals("")){
            JOptionPane.showMessageDialog(this , "please enter UserName","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if( pass.equals("")){
            JOptionPane.showMessageDialog(this , "please enter Password","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if( cpass.equals("")){
            JOptionPane.showMessageDialog(this , "please Confirm the Password","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
         if( dob == null){
            JOptionPane.showMessageDialog(this , "please enter the Date Of Birth","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(  con_no.equals("")|| con_no.matches("[0-9]+") == false){
            JOptionPane.showMessageDialog(this , "please enter contact Number","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if(!pass.equals(cpass)){
             JOptionPane.showMessageDialog(this , "password not match","Warning",JOptionPane.WARNING_MESSAGE);
             return false;
        }
        return true; 
    }
    public void checkph_number(){
         con_no = txt_contact.getText();
        if(con_no.length()==10) {
            lbl_ph_error.setText("");
        }else{
             lbl_ph_error.setText("Contact should be 10 digit");
        }
    }
    public void checkpassword (){
        pass = txt_password.getText();
          cpass = txt_conpassword.getText();
        if(pass.length()<8) {
            lbl_password_error.setText("password should be 8 digit");
        }else{
             lbl_password_error.setText("");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog3 = new datechooser.beans.DateChooserDialog();
        choice1 = new java.awt.Choice();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        password = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_conpassword = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_signup = new javax.swing.JButton();
        lbl_ph_error = new javax.swing.JLabel();
        lbl_password_error = new javax.swing.JLabel();
        txt_dob = new com.toedter.calendar.JDateChooser();

        jLabel9.setText("jLabel9");

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 58, 83));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Sign in");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 80));

        password.setBackground(new java.awt.Color(173, 239, 209));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 58, 83));
        jLabel2.setText("LastName ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(14, 58, 83));
        jLabel3.setText("Username ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 58, 83));
        jLabel4.setText("FirstName ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 58, 83));
        jLabel5.setText("Confirm Password ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 58, 83));
        jLabel6.setText("Password ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(14, 58, 83));
        jLabel7.setText("Contact No ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 58, 83));
        jLabel8.setText("DOB ");

        txt_firstname.setBackground(new java.awt.Color(255, 255, 204));
        txt_firstname.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        txt_firstname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstnameActionPerformed(evt);
            }
        });

        txt_lastname.setBackground(new java.awt.Color(255, 255, 204));
        txt_lastname.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        txt_lastname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txt_username.setBackground(new java.awt.Color(255, 255, 204));
        txt_username.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        txt_contact.setBackground(new java.awt.Color(255, 255, 204));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_contact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactKeyReleased(evt);
            }
        });

        txt_conpassword.setBackground(new java.awt.Color(255, 255, 204));
        txt_conpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_conpassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_conpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_conpasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_conpasswordKeyTyped(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(255, 255, 204));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(14, 58, 83));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\login.png")); // NOI18N
        btn_login.setText("  Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_signup.setBackground(new java.awt.Color(14, 58, 83));
        btn_signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_signup.setForeground(new java.awt.Color(255, 255, 255));
        btn_signup.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Desktop\\my icons\\signup.png")); // NOI18N
        btn_signup.setText(" Submit");
        btn_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_signupMouseClicked(evt);
            }
        });
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        lbl_ph_error.setBackground(new java.awt.Color(0, 153, 153));
        lbl_ph_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_ph_error.setForeground(new java.awt.Color(255, 51, 51));
        lbl_ph_error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_ph_errorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_ph_errorKeyReleased(evt);
            }
        });

        lbl_password_error.setBackground(new java.awt.Color(0, 153, 153));
        lbl_password_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_password_error.setForeground(new java.awt.Color(255, 51, 51));
        lbl_password_error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_password_errorKeyReleased(evt);
            }
        });

        txt_dob.setBackground(new java.awt.Color(255, 255, 204));
        txt_dob.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dob.setForeground(new java.awt.Color(0, 102, 0));
        txt_dob.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        javax.swing.GroupLayout passwordLayout = new javax.swing.GroupLayout(password);
        password.setLayout(passwordLayout);
        passwordLayout.setHorizontalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordLayout.createSequentialGroup()
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_password_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_ph_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_firstname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_contact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_conpassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txt_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(passwordLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(545, 545, 545))
        );
        passwordLayout.setVerticalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_password))
                .addGap(4, 4, 4)
                .addComponent(lbl_password_error, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(txt_dob, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ph_error, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        txt_dob.getAccessibleContext().setAccessibleParent(txt_dob);

        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 490, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
     
        login_page  l1 = new login_page();
      l1.show();
      this.dispose();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
       
              if(validation()==true){
                login_page  l1 = new login_page();
                   l1.show();
                  this.dispose();
        }
        

    }//GEN-LAST:event_btn_signupActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        checkpassword();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void lbl_ph_errorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_ph_errorKeyReleased
        checkph_number();
    }//GEN-LAST:event_lbl_ph_errorKeyReleased

    private void lbl_password_errorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_password_errorKeyReleased
        checkpassword();
    }//GEN-LAST:event_lbl_password_errorKeyReleased

    private void lbl_ph_errorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_ph_errorKeyPressed
      
    }//GEN-LAST:event_lbl_ph_errorKeyPressed

    private void txt_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyPressed
        checkph_number();
    }//GEN-LAST:event_txt_contactKeyPressed

    private void txt_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyReleased
      checkph_number();
    }//GEN-LAST:event_txt_contactKeyReleased

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
         checkpassword();
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_conpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_conpasswordKeyReleased
       checkpassword();
    }//GEN-LAST:event_txt_conpasswordKeyReleased

    private void txt_conpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_conpasswordKeyTyped
       checkpassword();
    }//GEN-LAST:event_txt_conpasswordKeyTyped

    private void btn_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_signupMouseClicked
            if( validation()){
            insertData();
        }
        else{
             JOptionPane.showMessageDialog(this , "Validation Issue","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_signupMouseClicked

    private void txt_firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstnameActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed
   
    public static void main(String args[]) {
          java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private java.awt.Choice choice1;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserDialog dateChooserDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_password_error;
    private javax.swing.JLabel lbl_ph_error;
    private javax.swing.JPanel password;
    private javax.swing.JPasswordField txt_conpassword;
    private javax.swing.JTextField txt_contact;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
