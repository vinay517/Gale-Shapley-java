/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gale4;

/**
 *
 * @author VINAY MOHAN
 */
public class Gale5  {
    String[] m_List;
    String[] w_List;
    String[][] m_Preference_Value;
    String[][] w_Preference_Value;
    int n, count;
    String[] w_Partner_Value;
    String[] m_Partner_Value;
    boolean[] m_Coupled;
    /*constructor*/
     public Gale5(String[] ml, String[] wl, String[][] mpv, String[][] wpv)
    {
        n = mpv.length;
        count = 0;
        m_List = ml;
        w_List = wl;
        m_Preference_Value = mpv;
        w_Preference_Value = wpv;
        m_Coupled = new boolean[n];
        w_Partner_Value = new String[n];
        couple_Matching();
    }

    
     private void couple_Matching()
    {
        double initiated = System.nanoTime();
        while (count < n)
        {
            int v;
            for (v = 0; v < n; v++)
                if (!m_Coupled[v])
                    break;
 
            for (int i = 0; i < n && !m_Coupled[v]; i++)
            {
                int m = w_Index(m_Preference_Value[v][i]);
                if (w_Partner_Value[m] == null)
                {
                    w_Partner_Value[m] = m_List[v];
                    m_Coupled[v] = true;
                    count++;
                }
                else
                {
                    String currentPartner = w_Partner_Value[m];
                    if (morePreference(currentPartner, m_List[v], m))
                    {
                        w_Partner_Value[m] = m_List[v];
                        m_Coupled[v] = true;
                        m_Coupled[m_Index(currentPartner)] = false;
                    }
                }
            }            
        }
        double finalized   = System.nanoTime();
        double rntimevalue = finalized - initiated;
        System.out.println("TIME TAKEN:"+rntimevalue/1000000+"seconds");
        output_Couples();
    }
 private boolean morePreference(String curPartner, String newPartner, int index)
    {
         int i=0;
        while(i<n)
        {
            if (w_Preference_Value[index][i].equals(newPartner))
                return true;
            if (w_Preference_Value[index][i].equals(curPartner))
                return false;
            i++;
        }
        
        return false;
    }
    /** getting men index value **/
    private int m_Index(String str)
    {
        for (int i = 0; i < n; i++)
            if (m_List[i].equals(str))
                return i;
        return -1;
    }
    /* getting women index value */
    private int w_Index(String str)
    {
        for (int i = 0; i < n; i++)
            if (w_List[i].equals(str))
                return i;
        return -1;
    }
    /*output couples after gs algorithm*/
    public void output_Couples()
    {
        System.out.println("Couples obtained after the implementation of Gale Shapley Algorithm: ");
        int i=0;
        while(i<n)
        {
            System.out.printf("%-20s%10s%n",w_List[i],w_Partner_Value[i]);
            i++;
        }
    }
    /*Random generation of men preferences and women preferences based on input in the main function*/
    public void randomGeneration(String[][] mpv,String[][] wpv)
    {
        String[] ml = {"M1", "M2", "M3", "M4", "M5","M6","M7","M8","M9","M10"};
        /** list of women **/
        String[] wl = {"W1", "W2", "W3", "W4", "W5","W6","W7","W8","W9","W10"};
        for(int i=0;i<mpv.length;i++)
        {
            for(int j=0;j<mpv[i].length;j++)
            {
                int i1 = i;
                int j1 = (int)(Math.random()*mpv.length);
                String temp = mpv[i][j];
                mpv[i][j] = mpv[i1][j1];
                mpv[i1][j1] = temp;
                
            }
        }
         for (String[] wpv1 : wpv) {
             for (int j = 0; j < wpv1.length; j++) {
                 int j1 = (int)(Math.random()*mpv.length);
                 String temp = wpv1[j];
                 wpv1[j] = wpv1[j1];
                 wpv1[j1] = temp;
             }
         }
        
         for (String[] wpv1 : wpv) {
            for (String wpv11 : wpv1) {
                System.out.print(wpv11);
            }
             System.out.println();
         }
         
         for (String[] mpv1 : mpv) {
            for (String mpv11 : mpv1) {
                System.out.print(mpv11);
            }
             System.out.println();
         }
       Gale5 gs1=new Gale5(ml,wl,mpv,wpv);     
    }     
  
}

