package Login;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pratiksha shetty
 */
public class Main_Window extends javax.swing.JFrame {

    /**
     * Creates new form Main_Window
     */
    public Main_Window() {
        initComponents();
       
        Show_Student_In_Table();
    }
    
    String ImgPath=null;
    int pos=0;
    public Connection getConnection()
    {
        try{
        Connection con=null;
        con = DriverManager.getConnection("jdbc:mysql://localhost/student_record","root","");
        
        return con;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE,null,ex);

            return null;

        }       
    }

    //Check Input Fields
    
    public boolean checkInputs()
    {
        if(jName==null || jRoll_No==null || jPid_No==null || jAtt==null || jPerf==null)
        {
            return false;
        }
        else
        {
            try{
                Float.parseFloat(jAtt.getText());
                Float.parseFloat(jPerf.getText());
                return true;
            }
            catch(Exception ex)
            {
                return false;
            }
        }
    }
    
    //RESIZE IMAGE
    
    
    
    public ImageIcon ResizeImage(String ImagePath,byte[] pic)
    {
        ImageIcon myImage=null;
        if(ImagePath!=null)
        {
            myImage = new ImageIcon(ImagePath);
        }
        else
        {
            myImage = new ImageIcon(pic);

        }
        Image img = myImage.getImage();
        Image img2=null;
        img2 = img.getScaledInstance(j_image.getWidth(),j_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image=  new ImageIcon(img2);
        return image;
    }
    
    //Display Data in  Table
    //(1) Fill ArrayList With Data
    
    public ArrayList <student_record> getStudentList()
    {
            ArrayList <student_record> studentList = new ArrayList <student_record>();
            Connection con=getConnection();
            String query="SELECT * FROM student_record.students";
            
            Statement st;
            ResultSet rs;
                    try {

            st=con.createStatement();
            rs=st.executeQuery(query); 
            student_record student;
            
            while(rs.next())
            {
                student=new student_record(rs.getBytes("image"),rs.getString("name"),rs.getInt("roll_no"),rs.getInt("pid"),Float.parseFloat(rs.getString("Attendance")),Float.parseFloat(rs.getString("performance"))
                );
                studentList.add(student);
                
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return studentList;
        
    }
    
    
    //(2)Populate the Table
    
    public void Show_Student_In_Table()
    {
        ArrayList <student_record> list;
        list = getStudentList();
        DefaultTableModel model=(DefaultTableModel)jTable.getModel();
        
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        for(int i= 0;i<list.size();i++)
        {
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getrn();
            row[2]=list.get(i).getpid();
            row[3]=list.get(i).getatt();
            row[4]=list.get(i).getperf();
        
            model.addRow(row);
        }
    }
    
    public void ShowItem(int index)
    {
        jName.setText(getStudentList().get(index).getName());
        jRoll_No.setText(Integer.toString(getStudentList().get(index).getrn()));
        jPid_No.setText(Integer.toString(getStudentList().get(index).getpid()));
        jAtt.setText(Float.toString(getStudentList().get(index).getatt()));
        jPerf.setText(Float.toString(getStudentList().get(index).getperf()));
        j_image.setIcon(ResizeImage(null,getStudentList().get(index).getImage()));
        

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPid_No = new javax.swing.JTextField();
        jName = new javax.swing.JTextField();
        jPerf = new javax.swing.JTextField();
        jAtt = new javax.swing.JTextField();
        jRoll_No = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        j_image = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jInsert = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        jUpdate = new javax.swing.JButton();
        jFirst = new javax.swing.JButton();
        jPrevious = new javax.swing.JButton();
        jNext = new javax.swing.JButton();
        jLast = new javax.swing.JButton();
        jExit = new javax.swing.JButton();
        Btn_Choose_Image = new javax.swing.JButton();
        lbl_search = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("NAME :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("ROLL_NO :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("PID_NO :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("ATTENDANCE :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("PERFORMANCE :");

        jPid_No.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPid_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPid_NoActionPerformed(evt);
            }
        });

        jName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameActionPerformed(evt);
            }
        });

        jPerf.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jPerf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPerfActionPerformed(evt);
            }
        });

        jAtt.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAttActionPerformed(evt);
            }
        });

        jRoll_No.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jRoll_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoll_NoActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "ROLL_NO", "PID_NO", "ATTENDANCE", "PERFORMANCE"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("IMAGE :");

        j_image.setPreferredSize(new java.awt.Dimension(154, 127));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel8.setText("STUDENT'S   RECORDS");

        jInsert.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jInsert.setText("INSERT");
        jInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInsertActionPerformed(evt);
            }
        });

        jDelete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jDelete.setText("DELETE");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jUpdate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jUpdate.setText("UPDATE");
        jUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateActionPerformed(evt);
            }
        });

        jFirst.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jFirst.setText("FIRST");
        jFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstActionPerformed(evt);
            }
        });

        jPrevious.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPrevious.setText("PREVIOUS");
        jPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPreviousActionPerformed(evt);
            }
        });

        jNext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jNext.setText("NEXT");
        jNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextActionPerformed(evt);
            }
        });

        jLast.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLast.setText("LAST");
        jLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastActionPerformed(evt);
            }
        });

        jExit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jExit.setText("EXIT");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        Btn_Choose_Image.setText("Choose File");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });

        lbl_search.setText("Enter any Value To be Searched");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_searchKeyTyped(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jExit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(72, 72, 72)
                                .addComponent(j_image, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Btn_Choose_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(lbl_search, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_search))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jAtt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPerf, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPid_No, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(77, 77, 77)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                            .addComponent(jRoll_No))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(109, 109, 109))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j_image, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRoll_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPid_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(39, 39, 39)
                                .addComponent(jLabel5))
                            .addComponent(jAtt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jPerf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 103, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jInsert)
                            .addComponent(jDelete)
                            .addComponent(jUpdate)
                            .addComponent(jFirst)
                            .addComponent(jPrevious)
                            .addComponent(jNext)
                            .addComponent(jLast)
                            .addComponent(jExit))
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_search)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search)
                            .addComponent(Btn_Choose_Image))
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPid_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPid_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPid_NoActionPerformed

    private void jNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameActionPerformed

    private void jPerfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPerfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPerfActionPerformed

    private void jAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAttActionPerformed

    private void jRoll_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRoll_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRoll_NoActionPerformed

    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path=selectedFile.getAbsolutePath();
            j_image.setIcon(ResizeImage(path,null));
            ImgPath=path;
            
        }
        else
        {
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

    private void jInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInsertActionPerformed
        if(checkInputs() && ImgPath!=null)
        {
            
            try {
                Connection con=getConnection();
                ArrayList <student_record> list;
        list = getStudentList();
         int id=list.size()+1;
                PreparedStatement ps=con.prepareStatement("INSERT INTO student_record.students(id,Name,Roll_no,PID,Attendance,Performance,Image) VALUES(?,?,?,?,?,?,?)");
                
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(7,img);
               String ID=String.valueOf(id);
                ps.setString(1,ID);
                ps.setString(2,jName.getText());
                ps.setString(3,jRoll_No.getText());
                ps.setString(4,jPid_No.getText());
                ps.setString(5,jAtt.getText());
                ps.setString(6,jPerf.getText());
                
                 ps.executeUpdate();
                 
                 Show_Student_In_Table();
                 
                 JOptionPane.showMessageDialog(null,"Data Inserted");
                         
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            
        }
    }//GEN-LAST:event_jInsertActionPerformed

    private void jUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateActionPerformed
        String UpdateQuery=null;
        PreparedStatement ps=null;
        Connection con=getConnection();
        if(checkInputs() && jRoll_No.getText()!=null)
        {
        //update without Image
        if(ImgPath==null)
        {
            try {
                UpdateQuery="UPDATE student_record.students SET Name=?,PID=?,Attendance=?,Performance=? WHERE Roll_no=?" ;
                ps =con.prepareStatement(UpdateQuery);
                
                ps.setString(1,jName.getText());
                ps.setString(5,jRoll_No.getText());
                ps.setString(2,jPid_No.getText());
                ps.setString(3,jAtt.getText());
                ps.setString(4,jPerf.getText());
                ps.executeUpdate();
               Show_Student_In_Table();
                JOptionPane.showMessageDialog(null,"Studen List Updated");
                
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        // update with image
        else
        {
            try {
                UpdateQuery="UPDATE student_record.students SET Name=?,PID=?,Attendance=?,Performance=?,Image=? WHERE Roll_no=?" ;
                ps =con.prepareStatement(UpdateQuery);
                
                ps.setString(1,jName.getText());
                ps.setString(6,jRoll_No.getText());
                ps.setString(2,jPid_No.getText());
                ps.setString(3,jAtt.getText());
                ps.setString(4,jPerf.getText());
                InputStream img = new FileInputStream(new File(ImgPath));

                ps.setBlob(5,img);
                ps.executeUpdate();
                Show_Student_In_Table();

                JOptionPane.showMessageDialog(null,"Student List Updated");
                        } 
            catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"One or More Fields are Empty");
        }
    }//GEN-LAST:event_jUpdateActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        if(!jRoll_No.getText().equals(""))
        {
        
            try {
                Connection con=getConnection();
                PreparedStatement ps;
            
                ps = con.prepareStatement("DELETE FROM student_record.students WHERE Roll_no=?");
                ps.setString(1,jRoll_No.getText());
                ps.executeUpdate();
                Show_Student_In_Table();

                JOptionPane.showMessageDialog(null,"Selected Entry Deleted");
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Selected Entry Not Deleted");
            }
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Entry Not Deleted: Select Roll_no");
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
            int index=jTable.getSelectedRow();
            ShowItem(index);
    }//GEN-LAST:event_jTableMouseClicked

    private void jFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstActionPerformed
        pos=0;
        ShowItem(pos);
        jTable.setRowSelectionInterval(pos, pos);
    }//GEN-LAST:event_jFirstActionPerformed

    private void jLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastActionPerformed
        pos=getStudentList().size()-1;
        ShowItem(pos);
        jTable.setRowSelectionInterval(pos, pos);
    }//GEN-LAST:event_jLastActionPerformed

    private void jNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextActionPerformed
        pos++;
        if(pos>=getStudentList().size())
        {
            pos=getStudentList().size()-1;
        }
        ShowItem(pos);
        jTable.setRowSelectionInterval(pos, pos);
    }//GEN-LAST:event_jNextActionPerformed

    private void jPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPreviousActionPerformed
        pos--;
        if(pos<0)
        {
            pos=0;
        }
        ShowItem(pos);
        jTable.setRowSelectionInterval(pos, pos);
    }//GEN-LAST:event_jPreviousActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        Options obj = new Options();
        obj.setVisible(true);
    }//GEN-LAST:event_jExitActionPerformed

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
         if(!"".equals(txt_search.getText())){
        String word=txt_search.getText();
        Connection con=getConnection();
            try {
                PreparedStatement ps=con.prepareStatement("SELECT * FROM students WHERE Name=? OR Roll_no=? OR PID=? OR Attendance=? OR Performance=?");
                ps.setString(1,word);
                ps.setString(2,word);
                ps.setString(3,word);
                ps.setString(4,word);
                ps.setString(5,word);
                ResultSet rs;
                rs = ps.executeQuery();
                DefaultTableModel model1=(DefaultTableModel)jTable.getModel();
        
        model1.setRowCount(0);
        
        Object[] row1 = new Object[5];
        while(rs.next())
        {
            row1[0]=rs.getString("Name");
            row1[1]=rs.getInt("Roll_no");
            row1[2]=rs.getInt("PID");
            row1[3]=rs.getFloat("Attendance");
            row1[4]=rs.getFloat("Performance");
            pos=(rs.getInt("id"))-1;
            model1.addRow(row1);
            
            
            
           }
        ShowItem(pos);
        
            }
            catch (SQLException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }}
        else{
            Show_Student_In_Table();
        }
         
    }//GEN-LAST:event_btn_searchMouseClicked

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyTyped
        if(!"".equals(txt_search.getText())){
        String word=txt_search.getText();
        Connection con=getConnection();
            try {
                PreparedStatement ps=con.prepareStatement("SELECT * FROM students WHERE Name=? OR Roll_no=? OR PID=? OR Attendance=? OR Performance=?");
                ps.setString(1,word);
                ps.setString(2,word);
                ps.setString(3,word);
                ps.setString(4,word);
                ps.setString(5,word);
                ResultSet rs;
                rs = ps.executeQuery();
                DefaultTableModel model1=(DefaultTableModel)jTable.getModel();
        
        model1.setRowCount(0);
        
        Object[] row1 = new Object[5];
        while(rs.next())
        {
            row1[0]=rs.getString("Name");
            row1[1]=rs.getInt("Roll_no");
            row1[2]=rs.getInt("PID");
            row1[3]=rs.getFloat("Attendance");
            row1[4]=rs.getFloat("Performance");
            pos=(rs.getInt("id"))-1;
            model1.addRow(row1);
            
        }
        ShowItem(pos);
        
            }
            catch (SQLException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }}
        else{
            Show_Student_In_Table();
        }
    }//GEN-LAST:event_txt_searchKeyTyped

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
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton btn_search;
    private javax.swing.JTextField jAtt;
    private javax.swing.JButton jDelete;
    private javax.swing.JButton jExit;
    private javax.swing.JButton jFirst;
    private javax.swing.JButton jInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jLast;
    private javax.swing.JTextField jName;
    private javax.swing.JButton jNext;
    private javax.swing.JTextField jPerf;
    private javax.swing.JTextField jPid_No;
    private javax.swing.JButton jPrevious;
    private javax.swing.JTextField jRoll_No;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jUpdate;
    private javax.swing.JLabel j_image;
    private javax.swing.JLabel lbl_search;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
