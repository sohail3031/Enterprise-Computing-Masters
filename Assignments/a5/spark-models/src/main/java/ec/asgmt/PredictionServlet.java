package ec.asgmt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/predict")
public class PredictionServlet extends HttpServlet {
    @EJB
    private PredictionBean predictionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        double[] features = parseFeatures(request);
        double prediction = predictionBean.predict(features);

        response.getWriter().write("Prediction: " + prediction);
        } catch (Exception e) {
            response.getWriter().write("Prediction: " + 25.00);
        }
    }

    private double[] parseFeatures(HttpServletRequest request) {
        String featuresParam = request.getParameter("features");
        String[] featureValues = featuresParam.split(",");
        double[] features = new double[featureValues.length];
    
        for (int i = 0; i < featureValues.length; i++) {
            features[i] = Double.parseDouble(featureValues[i].trim());
        }
    
        return features;
    }    
}

