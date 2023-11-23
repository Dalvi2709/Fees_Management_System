
package com.mycompany.fees_managmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Search_Details_page extends javax.swing.JFrame {

    public Search_Details_page() {
        initComponents();
        setRecordToTable();
    }
   DefaultTableModel model;
    public void setRecordToTable(){
         try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management_system?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "asdf123");
        PreparedStatement pst = con.prepareStatement("select * from fees_details ");
       ResultSet rs = pst.executeQuery();
       while(rs.next()){
           String recieptno = rs.getString("reciept_no");
           String studentname = rs.getString("student_name");
           String rollno = rs.getString("roll_no");
           String paymentmode = rs.getString("payment_mode");
           String coursename = rs.getString("course_name");
           float amount = rs.getFloat("amount");
           String remark = rs.getString("remark");
           
           Object[] obj = {recieptno,studentname,rollno,paymentmode,coursename,amount,remark };
           
           model =  (DefaultTableModel)table_stu_data.getModel();
           model.addRow(obj);
           
           
       }
       
    }
      catch(Exception e)
    {
        e.printStackTrace();
        e.toString();
        System.out.println(e.getMessage());
    }
    }
    
    
    public void search(String str){
        model = (DefaultTableModel)table_stu_data.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        table_stu_data.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_stu_data = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_search_data = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 58, 83));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));

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
                .addContainerGap(19, Short.MAX_VALUE)
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
                .addContainerGap(202, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 680));

        jPanel2.setBackground(new java.awt.Color(173, 239, 209));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_stu_data.setBackground(new java.awt.Color(255, 204, 204));
        table_stu_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table_stu_data.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_stu_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reciept No", "Student Name", "Roll No", "Mode Of Payment", "Course", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(table_stu_data);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 830, 410));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Enter the String ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        txt_search_data.setBackground(new java.awt.Color(255, 255, 204));
        txt_search_data.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_search_data.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_search_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_search_dataActionPerformed(evt);
            }
        });
        txt_search_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search_dataKeyReleased(evt);
            }
        });
        jPanel2.add(txt_search_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 370, 40));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\NetBeansProjects\\fees_managmentSystem\\src\\main\\java\\search2.png")); // NOI18N
        jLabel1.setText("Search Record");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(310, 310, 310))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 890, 80));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 920, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 920, 680));

        setSize(new java.awt.Dimension(1207, 683));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:
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

    private void txt_search_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_search_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_search_dataActionPerformed

    private void txt_search_dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_dataKeyReleased
        String searchString = txt_search_data.getText();
        search(searchString);
    }//GEN-LAST:event_txt_search_dataKeyReleased

    private void btn_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseClicked
       EditCourse_Page e = new EditCourse_Page();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_edit_courseMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_Details_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_course_list;
    private javax.swing.JButton btn_edit_course;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_search_record;
    private javax.swing.JButton btn_view_records;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table_stu_data;
    private javax.swing.JTextField txt_search_data;
    // End of variables declaration//GEN-END:variables
}
