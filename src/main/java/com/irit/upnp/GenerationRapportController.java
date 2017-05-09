package com.irit.upnp;

import org.fourthline.cling.binding.annotations.*;

import java.beans.PropertyChangeSupport;

/**
 * Created by mkostiuk on 09/05/2017.
 */
@UpnpService(
        serviceType = @UpnpServiceType("GenerationRapportController"),
        serviceId = @UpnpServiceId(value = "GenerationRapportController")
)
public class GenerationRapportController {

    private final PropertyChangeSupport propertyChangeSupport;

    public GenerationRapportController() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    @UpnpStateVariable(sendEvents = false)
    private String votes = "";

    public void setVotes(@UpnpInputArgument(name = "NewVotesValue") String v) {
        votes = v;
        propertyChangeSupport.firePropertyChange("votes", "", votes);
    }
}
