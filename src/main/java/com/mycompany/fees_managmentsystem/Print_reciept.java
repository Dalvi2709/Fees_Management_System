
package com.mycompany.fees_managmentsystem;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Print_reciept extends javax.swing.JFrame {

   
    public Print_reciept() {
        initComponents();
        getRecords();
    }
    
    
    public void getRecords()
    {
         try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
      PreparedStatement pst = con.prepareStatement("select * from fees_details order by reciept_no desc limit 1");
      ResultSet rs = pst.executeQuery();
      rs.next();
      txt_reciept_no.setText(rs.getString("reciept_no"));
      txt_payment_mode.setText(rs.getString("payment_mode"));
      String paymentmode = rs.getString("payment_mode");
      if(paymentmode.equalsIgnoreCase("cash")){
          txt_Cheque_no.setText("");
          txt_dd_no.setText("");
          txt_transaction_no.setText("");
          txt_bank_name.setText("");
      }
      if(paymentmode.equalsIgnoreCase("dd")){
          txt_Cheque_no.setText("");
          txt_dd_no.setText(rs.getString("dd_no"));
          txt_transaction_no.setText("");
          txt_bank_name.setText(rs.getString("bank_name"));
      }
       if(paymentmode.equalsIgnoreCase("cheque")){
          txt_Cheque_no.setText(rs.getString("cheque_no"));
          txt_dd_no.setText("");
          txt_transaction_no.setText("");
          txt_bank_name.setText(rs.getString("bank_name"));
      }
      if(paymentmode.equalsIgnoreCase("phonepay")){
          txt_Cheque_no.setText("");
          txt_dd_no.setText("");
          txt_transaction_no.setText(rs.getString("transaction_no"));
          txt_bank_name.setText("");
      }
      
          txt_recivefrom.setText(rs.getString("student_name"));
          txt_DateChooser.setDate(rs.getDate("dates"));
          txt_year1.setText(rs.getString("year1"));
          txt_year2.setText(rs.getString("year2"));
          txt_initial_amount.setText(rs.getString("amount"));
          txt_total_in_words.setText(rs.getString("total_in_words"));
          txt_remark.setText(rs.getString("remark"));
          txt_total.setText(rs.getString("total_amount"));
          
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
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
        btn_Print = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        Panel_print_reciept = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_reciept_no = new javax.swing.JLabel();
        txt_reciept_no = new javax.swing.JTextField();
        lbl_payment_mode = new javax.swing.JLabel();
        txt_payment_mode = new javax.swing.JTextField();
        lbl_dd_no = new javax.swing.JLabel();
        txt_dd_no = new javax.swing.JTextField();
        lbl_bank_name = new javax.swing.JLabel();
        txt_initial_amount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_recivefrom = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_year2 = new javax.swing.JLabel();
        txt_DateChooser = new com.toedter.calendar.JDateChooser();
        lbl_recivefrom = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_bank_name = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        lbl_total_in_words = new javax.swing.JLabel();
        txt_total_in_words = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lbl_Cheque_no = new javax.swing.JLabel();
        txt_Cheque_no = new javax.swing.JTextField();
        lbl_transaction_no = new javax.swing.JLabel();
        txt_transaction_no = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(173, 239, 209));
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
        btn_search_record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_recordActionPerformed(evt);
            }
        });

        btn_edit_course.setBackground(new java.awt.Color(255, 204, 153));
        btn_edit_course.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_edit_course.setText("Edit Course");
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

        btn_Print.setBackground(new java.awt.Color(255, 204, 153));
        btn_Print.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_Print.setText("Print");
        btn_Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_PrintMouseClicked(evt);
            }
        });
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 204, 153));
        btn_edit.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_view_records, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_edit_course, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_course_list, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_search_record, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
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
                .addGap(23, 23, 23)
                .addComponent(btn_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 750));

        Panel_print_reciept.setBackground(new java.awt.Color(255, 255, 255));
        Panel_print_reciept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Panel_print_reciept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 34)); // NOI18N
        jLabel1.setText("  Dnyanshree Institute Of Engineering And Technology ");
        Panel_print_reciept.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 880, 50));

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Panel_print_reciept.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 900, 20));

        lbl_reciept_no.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_reciept_no.setText("Receipt no ");
        Panel_print_reciept.add(lbl_reciept_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, 30));

        txt_reciept_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_reciept_noActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_reciept_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 180, -1));

        lbl_payment_mode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_payment_mode.setText("Payment Mode");
        Panel_print_reciept.add(lbl_payment_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 90, 30));

        txt_payment_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_payment_modeActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_payment_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, -1));

        lbl_dd_no.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_dd_no.setText("dd no");
        Panel_print_reciept.add(lbl_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 50, 30));

        txt_dd_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dd_noActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, -1));

        lbl_bank_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_bank_name.setText("Bank name");
        Panel_print_reciept.add(lbl_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, 30));

        txt_initial_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_initial_amountActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_initial_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 190, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Date");
        Panel_print_reciept.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 30, 30));

        txt_recivefrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recivefromActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_recivefrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, -1));
        Panel_print_reciept.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, -1, -1));
        Panel_print_reciept.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 60, 30));
        Panel_print_reciept.add(txt_DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 160, -1));

        lbl_recivefrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_recivefrom.setText("Student name");
        Panel_print_reciept.add(lbl_recivefrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 90, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Year");
        Panel_print_reciept.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 40, 30));
        Panel_print_reciept.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 60, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("-");
        Panel_print_reciept.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 10, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Panel_print_reciept.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 900, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Amount");
        Panel_print_reciept.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 80, -1));

        jSeparator3.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Panel_print_reciept.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 900, 10));

        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 180, -1));

        jSeparator4.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Panel_print_reciept.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 190, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Total");
        Panel_print_reciept.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 60, -1));
        Panel_print_reciept.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 190, 30));

        lbl_total_in_words.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_total_in_words.setText("Total in words");
        Panel_print_reciept.add(lbl_total_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 100, -1));

        txt_total_in_words.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_total_in_words.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_in_wordsActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_total_in_words, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 500, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Remark");
        Panel_print_reciept.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 80, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        Panel_print_reciept.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 240, 120));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Reciever Signature");
        Panel_print_reciept.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 140, -1));

        jSeparator5.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(255, 102, 102));
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Panel_print_reciept.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 240, 10));

        lbl_Cheque_no.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_Cheque_no.setText("Cheque  no");
        Panel_print_reciept.add(lbl_Cheque_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 100, 30));

        txt_Cheque_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cheque_noActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_Cheque_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 180, -1));

        lbl_transaction_no.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_transaction_no.setText("transaction no");
        Panel_print_reciept.add(lbl_transaction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 100, 30));

        txt_transaction_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_transaction_noActionPerformed(evt);
            }
        });
        Panel_print_reciept.add(txt_transaction_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 170, 20));

        getContentPane().add(Panel_print_reciept, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 900, 630));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel18.setText("  Print Receipt");
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 280, -1));

        setSize(new java.awt.Dimension(1356, 756));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked

        home_page hp = new home_page();
        hp.show();
        this.dispose();
    }//GEN-LAST:event_btn_homeMouseClicked

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

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        // TODO add your handling code here:
        home_page hp = new home_page();
        hp.show();
        this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        // TODO add your handling code here:
        login_page  l1 = new login_page();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_PrintMouseClicked
       
        
        
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47,0.47);
                
               Panel_print_reciept.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }
    }//GEN-LAST:event_btn_PrintMouseClicked

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PrintActionPerformed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        // TODO add your handling code here:
        Update_Fees_details u = new Update_Fees_details();
        u.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_editMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_reciept_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_reciept_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_reciept_noActionPerformed

    private void txt_payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_payment_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_payment_modeActionPerformed

    private void txt_dd_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dd_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dd_noActionPerformed

    private void txt_initial_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_initial_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_initial_amountActionPerformed

    private void txt_recivefromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recivefromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_recivefromActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void txt_total_in_wordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_in_wordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_in_wordsActionPerformed

    private void txt_Cheque_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cheque_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cheque_noActionPerformed

    private void txt_transaction_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_transaction_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_transaction_noActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Print_reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_reciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_reciept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_print_reciept;
    private javax.swing.JButton btn_Print;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_Cheque_no;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_dd_no;
    private javax.swing.JLabel lbl_payment_mode;
    private javax.swing.JLabel lbl_reciept_no;
    private javax.swing.JLabel lbl_recivefrom;
    private javax.swing.JLabel lbl_total_in_words;
    private javax.swing.JLabel lbl_transaction_no;
    private javax.swing.JTextField txt_Cheque_no;
    private com.toedter.calendar.JDateChooser txt_DateChooser;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_dd_no;
    private javax.swing.JTextField txt_initial_amount;
    private javax.swing.JTextField txt_payment_mode;
    private javax.swing.JTextField txt_reciept_no;
    private javax.swing.JTextField txt_recivefrom;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_in_words;
    private javax.swing.JTextField txt_transaction_no;
    private javax.swing.JLabel txt_year1;
    private javax.swing.JLabel txt_year2;
    // End of variables declaration//GEN-END:variables
}
