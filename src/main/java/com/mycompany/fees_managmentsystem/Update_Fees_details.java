package com.mycompany.fees_managmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Update_Fees_details extends javax.swing.JFrame {

    
    
//     Constructor Class
    
    public Update_Fees_details() {
        initComponents();
        displayCashFirst();
        fillcomboboxofcourse();
        int r =getrecieptNo();
        r++;
        txt_receipt_no.setText(Integer.toString(r));
        setRecords();
    }
    
//     Main Database Method Insserting Data in Table
    
       public String UpdateFeesData(){
                   String status="";
             int receiptno = Integer.parseInt(txt_receipt_no.getText());
             String stname = txt_reciver_name.getText();
             String rollno = txt_roll_no.getText();
             String paymentmode = combo_mode_of_payment.getSelectedItem().toString();
             String chequeno =txt_cheque_no1.getText();
             String transactionno =txt_transiction_no.getText();
             String ddno = txt_dd_no.getText();
             String bankname =txt_bank_name.getText();
             String coursename = Combo_coursemain.getSelectedItem().toString();
             float totalamount = Float.parseFloat(txt_total.getText());
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String date = dateFormat.format(datechooser.getDate());
             float amount = Float.parseFloat(txt_amount.getText());
             String totalinwords = txt_total_in_words.getText();
             String remark = txt_remark.getText();
             int year1 = Integer.parseInt(fromyear.getText());
             int year2 = Integer.parseInt(toyear.getText());

   try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("update fees_details set student_name = ?, roll_no =?, payment_mode = ? , cheque_no =?,transaction_no =?, dd_no =?,bank_name =?,course_name =?, total_amount = ?,"
                                                          + "dates =?,  amount = ?, total_in_words =?, remark =?,year1=?, year2=? where reciept_no = ?  ");
               
                pst.setString(1, stname);
                pst.setString(2,rollno);
                pst.setString(3, paymentmode);
                pst.setString(4, chequeno);
                pst.setString(5, transactionno);
                pst.setString(6,  ddno);
                pst.setString(7, bankname);
                pst.setString(8,  coursename);
                pst.setFloat(9, totalamount);
                pst.setString(10, date);
                pst.setFloat(11, amount);
                pst.setString(12,totalinwords);
                pst.setString(13,remark);
                pst.setInt(14,year1);
                pst.setInt(15,year2);
                pst.setInt(16,receiptno);

    int c = pst.executeUpdate();
    if(c==1)
      {
          status="success";
      }
    else
      {
            status = "failed";
      }
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
       return status;
    }  
       
//       Set the records for editing 
       public void setRecords(){
           try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
                  PreparedStatement pst = con.prepareStatement("select * from fees_details order by reciept_no desc limit 1");
                 ResultSet rs= pst.executeQuery();
                 rs.next();
                 
                 txt_receipt_no.setText(rs.getString("reciept_no"));
                 txt_reciver_name.setText(rs.getString("student_name"));
                 txt_roll_no.setText(rs.getString("roll_no"));
                 combo_mode_of_payment.setSelectedItem(rs.getString("payment_mode"));
                 txt_cheque_no1.setText(rs.getString("cheque_no"));
                 txt_transiction_no.setText(rs.getString("transaction_no"));
                 txt_dd_no.setText(rs.getString("dd_no"));        
                 txt_bank_name.setText(rs.getString("bank_name"));
                 Combo_coursemain.setSelectedItem(rs.getString("course_name"));        
                 txt_total.setText(rs.getString("total_amount"));
                 datechooser.setDate(rs.getDate("dates"));        
                 txt_amount.setText(rs.getString("amount"));       
                 txt_total_in_words.setText(rs.getString("total_in_words"));       
                 txt_remark.setText(rs.getString("remark")); 
                 fromyear.setText(rs.getString("year1"));  
                 toyear.setText(rs.getString("year2"));        
                         
                         
                         
           }catch(Exception e){
                 e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
           }
       }
    
    
//       AutoIncrement Receipt No Method Start
    
         public int getrecieptNo()
         {
            int rno = 0;
   try
      {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select max(reciept_no) from fees_details");
      ResultSet rs = pst.executeQuery();
        if(rs.next()==true)
        {
          rno = rs.getInt(1);
        }
      
      }
       catch(Exception e)
      {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
      }
           return rno;
     }
    
//         Autofill Course Method
         
     public void fillcomboboxofcourse(){
           try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select CName from coursedetails");
     ResultSet rs = pst.executeQuery();
      while(rs.next()){
         Combo_coursemain.addItem(rs.getString("CName"));
      }
      
 }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
     }
     
     
//   Display lables Method
     
     public void displayCashFirst(){
        
        lbl_dd_no.setVisible(false);
        lbl_transiction_no.setVisible(false);
        txt_dd_no.setVisible(false);
        txt_transiction_no.setVisible(false);
        lbl_bank__name.setVisible(false);
        txt_bank_name.setVisible(false);
           txt_cheque_no1.setVisible(false);
         lbl_cheque_no1.setVisible(false);
         txt_reciver_name.setVisible(true);
         lbl_reciver_name.setVisible(true);
    }
     
//     Validation of print button 
     
     boolean validation(){
        if( txt_reciver_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Reciver Name ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
        if(datechooser.getDate()==(null)){
                    JOptionPane.showMessageDialog(this , "please enter Date ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          if( txt_amount.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Valid Amount ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
      if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("cheque")){
              if( txt_cheque_no1.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter cheque Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
              if( txt_bank_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Bank Name","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
      if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("DD")){
              if( txt_dd_no.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter DD Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
              if( txt_bank_name.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Bank Name","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
       if(combo_mode_of_payment.getSelectedItem().toString().equalsIgnoreCase("phonepay")){
              if( txt_transiction_no.getText().equals("")){
                    JOptionPane.showMessageDialog(this , "please enter Transiction Number ","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
          }
                return true;   
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_home = new javax.swing.JButton();
        btn_search_record = new javax.swing.JButton();
        btn_edit_course = new javax.swing.JButton();
        btn_course_list = new javax.swing.JButton();
        btn_view_records = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_mode_of_payment = new javax.swing.JLabel();
        lbl_dd_no = new javax.swing.JLabel();
        combo_mode_of_payment = new javax.swing.JComboBox<>();
        lbl_transiction_no = new javax.swing.JLabel();
        txt_receipt_no = new javax.swing.JTextField();
        txt_transiction_no = new javax.swing.JTextField();
        lbl_bank__name = new javax.swing.JLabel();
        txt_bank_name = new javax.swing.JTextField();
        lbl_date = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        lbl_receipt_no = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_reciver_name = new javax.swing.JLabel();
        txt_reciver_name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbl_roll_no = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_total_in_words = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_course_head = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        toyear = new javax.swing.JTextField();
        lbl_roll_no1 = new javax.swing.JLabel();
        lbl_roll_no2 = new javax.swing.JLabel();
        txt_roll_no = new javax.swing.JTextField();
        fromyear = new javax.swing.JTextField();
        txt_dd_no = new javax.swing.JTextField();
        lbl_cheque_no1 = new javax.swing.JLabel();
        txt_cheque_no1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Combo_coursemain = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 58, 83));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_home.setBackground(new java.awt.Color(255, 204, 153));
        btn_home.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_home.setText("Home");
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
        });
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_search_record.setBackground(new java.awt.Color(255, 204, 153));
        btn_search_record.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_search_record.setText("Search Record");
        btn_search_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseClicked(evt);
            }
        });
        btn_search_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_recordActionPerformed(evt);
            }
        });

        btn_edit_course.setBackground(new java.awt.Color(255, 204, 153));
        btn_edit_course.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_edit_course.setText("Edit Course");
        btn_edit_course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_courseMouseClicked(evt);
            }
        });
        btn_edit_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_courseActionPerformed(evt);
            }
        });

        btn_course_list.setBackground(new java.awt.Color(255, 204, 153));
        btn_course_list.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_course_list.setText("Course List");
        btn_course_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_course_listActionPerformed(evt);
            }
        });

        btn_view_records.setBackground(new java.awt.Color(255, 204, 153));
        btn_view_records.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_view_records.setText("View Records");
        btn_view_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_recordsActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(255, 204, 153));
        btn_back.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_back.setText("Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_logout.setBackground(new java.awt.Color(255, 204, 153));
        btn_logout.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_view_records, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_edit_course, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_edit_course, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_view_records, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 600));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_mode_of_payment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_mode_of_payment.setText("Mode Of Payment ");
        jPanel2.add(lbl_mode_of_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        lbl_dd_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_dd_no.setText("DD No :");
        jPanel2.add(lbl_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        combo_mode_of_payment.setBackground(new java.awt.Color(255, 255, 204));
        combo_mode_of_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "DD", "PhonePay", "Cheque" }));
        combo_mode_of_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_of_paymentActionPerformed(evt);
            }
        });
        jPanel2.add(combo_mode_of_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 90, -1));

        lbl_transiction_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_transiction_no.setText("Transiction No");
        jPanel2.add(lbl_transiction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txt_receipt_no.setBackground(new java.awt.Color(255, 255, 204));
        txt_receipt_no.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        txt_receipt_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_receipt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, -1));

        txt_transiction_no.setBackground(new java.awt.Color(255, 255, 204));
        txt_transiction_no.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        txt_transiction_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_transiction_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_transiction_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_transiction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        lbl_bank__name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_bank__name.setText("Bank Name ");
        jPanel2.add(lbl_bank__name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txt_bank_name.setBackground(new java.awt.Color(255, 255, 204));
        txt_bank_name.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        txt_bank_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 90, -1));

        lbl_date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_date.setText("Date ");
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        datechooser.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 170, -1));

        lbl_receipt_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_receipt_no.setText("Receipt No  ");
        jPanel2.add(lbl_receipt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(173, 239, 209));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_reciver_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_reciver_name.setText("Reciver Name");
        jPanel3.add(lbl_reciver_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txt_reciver_name.setBackground(new java.awt.Color(255, 255, 204));
        txt_reciver_name.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        txt_reciver_name.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_reciver_name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_reciver_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_reciver_nameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_reciver_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 250, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Amont");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 80, -1));

        lbl_roll_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_roll_no.setText("to ");
        jPanel3.add(lbl_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 240, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 10));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Remark");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 80, -1));

        txt_total.setBackground(new java.awt.Color(255, 255, 204));
        txt_total.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 150, 30));

        txt_total_in_words.setBackground(new java.awt.Color(255, 255, 204));
        txt_total_in_words.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_total_in_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_in_wordsActionPerformed(evt);
            }
        });
        jPanel3.add(txt_total_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 260, 30));

        txt_amount.setBackground(new java.awt.Color(255, 255, 204));
        txt_amount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel3.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 150, 30));

        jSeparator3.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 650, 10));

        jSeparator4.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 180, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Total");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 80, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Reciever Signature");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 140, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Total in words");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 100, -1));

        txt_course_head.setBackground(new java.awt.Color(255, 255, 204));
        txt_course_head.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.add(txt_course_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 310, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Sr No");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, -1));

        txt_remark.setBackground(new java.awt.Color(255, 255, 204));
        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        txt_remark.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(txt_remark);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 260, 120));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Head");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 80, -1));

        btn_print.setBackground(new java.awt.Color(102, 102, 102));
        btn_print.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel3.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 130, 40));

        toyear.setBackground(new java.awt.Color(255, 255, 204));
        toyear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toyearActionPerformed(evt);
            }
        });
        jPanel3.add(toyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 80, -1));

        lbl_roll_no1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_roll_no1.setText("Roll No ");
        jPanel3.add(lbl_roll_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        lbl_roll_no2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_roll_no2.setText("from");
        jPanel3.add(lbl_roll_no2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        txt_roll_no.setBackground(new java.awt.Color(255, 255, 204));
        txt_roll_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_roll_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roll_noActionPerformed(evt);
            }
        });
        jPanel3.add(txt_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 90, -1));

        fromyear.setBackground(new java.awt.Color(255, 255, 204));
        fromyear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromyearActionPerformed(evt);
            }
        });
        jPanel3.add(fromyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 70, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 650, 420));

        txt_dd_no.setBackground(new java.awt.Color(255, 255, 204));
        txt_dd_no.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        txt_dd_no.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dd_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        lbl_cheque_no1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_cheque_no1.setText("Cheque No :");
        jPanel2.add(lbl_cheque_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txt_cheque_no1.setBackground(new java.awt.Color(255, 255, 204));
        txt_cheque_no1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        txt_cheque_no1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_cheque_no1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_no1ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cheque_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Course ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 80, -1));

        Combo_coursemain.setBackground(new java.awt.Color(255, 255, 204));
        Combo_coursemain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_coursemainActionPerformed(evt);
            }
        });
        jPanel2.add(Combo_coursemain, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 230, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("    Update Fees");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_search_recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_recordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_search_recordActionPerformed

    private void btn_edit_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_courseActionPerformed

    private void btn_course_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_course_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_course_listActionPerformed

    private void btn_view_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_recordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_view_recordsActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_noActionPerformed

    private void txt_transiction_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_transiction_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_transiction_noActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void txt_reciver_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_reciver_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_reciver_nameActionPerformed

    private void txt_total_in_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_in_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_in_wordsActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
        if(validation()==true){
          String s= UpdateFeesData();
       if(s.equals("success")){
              JOptionPane.showMessageDialog(this , "Records Updated Succesfully");
                Print_reciept p1 = new Print_reciept();
                p1.setVisible(true);
                this.dispose();
        }else{
            JOptionPane.showMessageDialog(this , "Records Updatation failed");
        }
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_dd_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_noActionPerformed
 // Which lbl is showing on action of combo box
    private void combo_mode_of_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_of_paymentActionPerformed
       
            if(combo_mode_of_payment.getSelectedIndex()==0)
        {
             lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            lbl_bank__name.setVisible(false);
            txt_bank_name.setVisible(false);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);
        }
        if(combo_mode_of_payment.getSelectedIndex()==1)
        {
            lbl_dd_no.setVisible(true);
            txt_dd_no.setVisible(true);
            lbl_bank__name.setVisible(true);
            txt_bank_name.setVisible(true);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);
        }
    
        if(combo_mode_of_payment.getSelectedIndex()==2)
        {
            lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(true);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(true);
            lbl_bank__name.setVisible(false);
            txt_bank_name.setVisible(false);
            txt_cheque_no1.setVisible(false);
            lbl_cheque_no1.setVisible(false);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);        
        }
        if(combo_mode_of_payment.getSelectedIndex()==3)
        {
            lbl_dd_no.setVisible(false);
            lbl_transiction_no.setVisible(false);
            txt_dd_no.setVisible(false);
            txt_transiction_no.setVisible(false);
            lbl_bank__name.setVisible(true);
            txt_bank_name.setVisible(true);
            txt_cheque_no1.setVisible(true);
            lbl_cheque_no1.setVisible(true);
            txt_reciver_name.setVisible(true);
            lbl_reciver_name.setVisible(true);   
        }
    }//GEN-LAST:event_combo_mode_of_paymentActionPerformed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
          home_page hp = new home_page();
           hp.show();
           this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
          home_page hp = new home_page();
           hp.show();
           this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
         login_page  l1 = new login_page();
      l1.show();
      this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void txt_cheque_no1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_no1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_no1ActionPerformed

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        // TODO add your handling code here:
       validation();
    }//GEN-LAST:event_btn_printMouseClicked

    private void Combo_coursemainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_coursemainActionPerformed
        // TODO add your handling code here:
        txt_course_head.setText( Combo_coursemain.getSelectedItem().toString());
    }//GEN-LAST:event_Combo_coursemainActionPerformed

    private void toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toyearActionPerformed

    private void txt_roll_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roll_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roll_noActionPerformed

    private void fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromyearActionPerformed

    private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
         Search_Details_page s =  new Search_Details_page();
          s.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_btn_search_recordMouseClicked

    private void btn_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseClicked
      EditCourse_Page e = new EditCourse_Page();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_edit_courseMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Fees_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_coursemain;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JComboBox<String> combo_mode_of_payment;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JTextField fromyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bank__name;
    private javax.swing.JLabel lbl_cheque_no1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dd_no;
    private javax.swing.JLabel lbl_mode_of_payment;
    private javax.swing.JLabel lbl_receipt_no;
    private javax.swing.JLabel lbl_reciver_name;
    private javax.swing.JLabel lbl_roll_no;
    private javax.swing.JLabel lbl_roll_no1;
    private javax.swing.JLabel lbl_roll_no2;
    private javax.swing.JLabel lbl_transiction_no;
    private javax.swing.JTextField toyear;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_cheque_no1;
    private javax.swing.JTextField txt_course_head;
    private javax.swing.JTextField txt_dd_no;
    private javax.swing.JTextField txt_receipt_no;
    private javax.swing.JTextField txt_reciver_name;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_roll_no;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_in_words;
    private javax.swing.JTextField txt_transiction_no;
    // End of variables declaration//GEN-END:variables
}
