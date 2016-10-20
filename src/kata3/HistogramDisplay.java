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
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("Histograma");
        this.histogram = histogram;
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
        JFreeChart chart = ChartFactory.createBarChart3D("JFreeChart Histogram", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, 
                false, rootPaneCheckingEnabled, rootPaneCheckingEnabled); // Crea el histograma en 3D.
        /*JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, 
                false, rootPaneCheckingEnabled, rootPaneCheckingEnabled); */
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
            //dataSet.addValue(histogram.get(key), key, key); //Muestra en colores.
        }
        return dataSet;
    }
}   


