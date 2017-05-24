/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irit.display;

import com.irit.xml.StockReponses;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author mkostiuk
 */
public class PieChart extends ApplicationFrame {
    
    private StockReponses stockReponses;
    
    public PieChart(String title, StockReponses sr) {
        super(title);
        stockReponses = sr;
        setContentPane(createDemoPanel( ));
    }
    
    private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset( ); 
        for ( int i = 0; i < stockReponses.getNbQuestions(); i++)
            dataset.setValue(new Integer(i+1), stockReponses.getReponses().get(i));
        return dataset;
    } 

    private JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Vote Results",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public JPanel createDemoPanel( ) {
      JFreeChart chart;  
        chart = createChart(createDataset( ) );
      return new ChartPanel( chart ); 
   }
    
}
