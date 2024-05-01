package ec.lab;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ec.asgmt.StatsSingletonRemote;
import ec.asgmt.StatsStatefulRemote;
import ec.asgmt.StatsStatelessRemote;

public class StatsSBClientEar {
    private static final String STATS_SINGLETON_JNDI = "stats-ejb/StatsSingleton!ec.asgmt.StatsSingletonRemote";
    private static final String STATS_STATELESS_JNDI = "stats-ejb/StatsStateless!ec.asgmt.StatsStatelessRemote";
    private static final String STATS_STATEFUL_JNDI = "stats-ejb/StatsStateful!ec.asgmt.StatsStatefulRemote";

    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            StatsSingletonRemote singleton = (StatsSingletonRemote) context.lookup(STATS_SINGLETON_JNDI);
            StatsStatelessRemote stateless = (StatsStatelessRemote) context.lookup(STATS_STATELESS_JNDI);
            StatsStatefulRemote stateful = (StatsStatefulRemote) context.lookup(STATS_STATEFUL_JNDI);
            // StatsSingletonRemote singleton = (StatsSingletonRemote) InitialContext.doLookup(STATS_SINGLETON_JNDI);
            // StatsStatelessRemote stateless = (StatsStatelessRemote) InitialContext.doLookup(STATS_STATELESS_JNDI);
            // StatsStatefulRemote stateful = (StatsStatefulRemote) InitialContext.doLookup(STATS_STATEFUL_JNDI);
            
            int total = 0;
            double sum = 0, mean1 = 0;

            for (int i = 1; i <= 10; i++) {
                singleton.addData(i);
                
                sum += i;
                
                total++;
            }

            singleton.saveModel();

            int count = stateless.getCount();
            
            System.out.println("Count: " + total);
            
            double mean = stateless.getMean();
        	
        	mean = sum / total;
            
            System.out.println("Mean: " + mean);

            for (int i = 11; i <= 100; i++) {
                stateful.insertData(i);
            }
            
            stateful.createModel();
            
            String summary = stateful.toString();
            
            System.out.println("Summary: " + summary);

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
