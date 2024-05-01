package ec.asgmt;

import org.springframework.stereotype.Component;

import weka.classifiers.functions.LinearRegression;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.SerializationHelper;

@Component
public class ModelBean {
	private String modelFile = "C:/enterprise/tmp/model/weka_regression.bin";

	public double predict(double[] attributes) {
		try {
			LinearRegression model = (LinearRegression) SerializationHelper.read(modelFile);
			Instance query1 = new DenseInstance(6);
			
			for (int i = 0; i < attributes.length; i++) {
				query1.setValue(i, attributes[i]);
			}
			
			double prediction = model.classifyInstance(query1);
			
			return prediction;
		} catch (Exception e) {
			e.printStackTrace();
			
			return 0.0;
		}
	}
    
}
