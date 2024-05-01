package ec.asgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {
    @Autowired
    private ModelBean modelBean;

    @GetMapping("/predict/{attributes}")
    public double predict(@PathVariable double[] attributes) {
        return modelBean.predict(attributes);
    }
}
