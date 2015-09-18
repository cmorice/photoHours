package photoHours;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;

import net.e175.klaus.solarpositioning.AzimuthZenithAngle;
import net.e175.klaus.solarpositioning.DeltaT;
import net.e175.klaus.solarpositioning.SPA;

@Path("/hours")
public class HoursResource {

	@GET
	@Path("/today")
	public Response get() {
		
		final DateTime today = new DateTime().withTimeAtStartOfDay();
		
		boolean endOfDay = false;
		while (!endOfDay) {
			
		}
		
		AzimuthZenithAngle position = SPA.calculateSolarPosition(
                today.toGregorianCalendar(),
                48.21, // latitude (degrees)
                16.37, // longitude (degrees)
                190, // elevation (m)
                DeltaT.estimate(today.toGregorianCalendar()) // delta T (s)
                );
		
		System.out.println(position);

		return Response.ok().build();
	}

}
