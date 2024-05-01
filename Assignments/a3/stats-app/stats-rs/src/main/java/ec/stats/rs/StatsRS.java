package ec.stats.rs;

// import javax.ejb.EJB;
// import javax.enterprise.context.RequestScoped;
// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;

// import ec.stats.sb.StatsStateless;
// import ec.stats.sb.StatsStatelessLocal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.stats.sb.StatsStateless;


// @Path("/")
// @RequestScoped
@Path("/rest")
public class StatsRS {
	
    // @EJB
    // private StatsStatelessLocal statsStateless;

    // @GET
    // @Path("/count")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String getCount() {
    //     return "{\"count\":" + statsStateless.getCount() + "}";
    // }

    // @GET
    // @Path("/min")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String getMin() {
    //     return "{\"min\":" + statsStateless.getMin() + "}";
    // }

    // @GET
    // @Path("/max")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String getMax() {
    //     return "{\"max\":" + statsStateless.getMax() + "}";
    // }

    // @GET
    // @Path("/mean")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String getMean() {
    //     return "{\"mean\":" + statsStateless.getMean() + "}";
    // }

    // @GET
    // @Path("/std")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String getSTD() {
    //     return "{\"std\":" + statsStateless.getSTD() + "}";
    // }

    @EJB
    private StatsStateless statsBean;

    @Path("/count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCount() {
        return "{\"count\":\"" + statsBean.getCount() + "\"}";
    }

    @Path("/min")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMin() {
        return "{\"min\":\"" + statsBean.getMin() + "\"}";
    }

    @Path("/max")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMax() {
        return "{\"max\":\"" + statsBean.getMax() + "\"}";
    }

    @Path("/mean")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMean() {
        return "{\"mean\":\"" + statsBean.getMean() + "\"}";
    }

    @Path("/std")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSTD() {
        return "{\"std\":\"" + statsBean.getSTD() + "\"}";
    }
}
