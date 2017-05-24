/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irit.display;

import com.irit.xml.StockReponses;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author mkostiuk
 */
public class BarChart extends ApplicationFrame {
    
    private StockReponses stockReponses;
    
    public BarChart(String title, String chartTitle, StockReponses sr) {
        super(title);
        stockReponses = sr;
        JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Réponses",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
        setContentPane(new ChartPanel(barChart));
    }
    
    public CategoryDataset createDataset() {
        
        final String reponse = "Reponse";
        
        final DefaultCategoryDataset dataset = 
            new DefaultCategoryDataset( ); 
        
        for (int i = 0; i < stockReponses.getNbQuestions(); i++) {
            Integer val = stockReponses.getReponses().get(i);
            dataset.addValue((Number)val,i,i);
        }
        
        
        return dataset;
    }
    
  
    
}
