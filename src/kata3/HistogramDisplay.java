package kata3;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {
    public HistogramDisplay() {
        super("Histograma");
        setContentPane(createPanel());
        pack(); // Crea la ventana con el tamaño mínimo para que todos los objetos sean visibles.
    }
    
    public void execute() {
        setVisible(true);
        
    }

    private JPanel createPanel() {
        // Creamos la ventana --> Creamos el panel --> Creamos el set de datos.
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, 
                false, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(10, "", "gmail.com");
        dataSet.addValue(15, "", "ulpgc.es");
        dataSet.addValue(12, "", "ull.es");
        dataSet.addValue(4, "", "hotmail.com");
        return dataSet;
    }
}   


