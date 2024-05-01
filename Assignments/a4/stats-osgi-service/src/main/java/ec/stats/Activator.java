package ec.stats;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
	private ServiceTracker<Object, Object> tracker;
	private StatsOSGi service;

	public void start(BundleContext context) throws Exception {
		service = new StatsOSGiImpl();

		context.registerService(StatsOSGi.class.getName(), service, null);

		System.out.println("stats-osgi-service bundle started.");
	}

	public void stop(BundleContext context) throws Exception {
		tracker.close();
		
		tracker = null;
		service = null;
		
		System.out.println("stats-osgi-service bundle stopped.");
	}
}
