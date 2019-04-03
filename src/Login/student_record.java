/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author pratiksha shetty
 */
public class student_record 
{
    private String name;
    private int roll_no;
    private float Att;
    private float perf;
    private int pid;
    private byte[] picture;
    
    public student_record(byte[] spic,String sname,int srn,int sid,float sAtt,float sperf)
    {
        this.picture=spic;
        this.name=sname;
        this.roll_no=srn;
        this.pid=sid;
        this.Att=sAtt;
        this.perf=sperf;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getrn()
    {
        return roll_no;
    }
    
    public int getpid()
    {
        return pid;
    }
    
    public float getatt()
    {
        return Att;
    }
    
    public float getperf()
    {
        return perf;
    }
    
    
    
}
