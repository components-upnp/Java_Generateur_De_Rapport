package com.irit.upnp;

import display.FenetrePrincipale;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.*;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;

/**
 * Created by mkostiuk on 09/05/2017.
 */
public class GenerateurDeRapportServer implements Runnable {
    public void run() {
        try {

            final UpnpService upnpService = new UpnpServiceImpl();

            // Add the bound local device to the registry
            upnpService.getRegistry().addDevice(
                    createDevice()
            );

        } catch (Exception ex) {
            System.err.println("Exception occured: " + ex);
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private LocalDevice createDevice() throws ValidationException {
        DeviceIdentity identity =
                new DeviceIdentity(
                        UDN.uniqueSystemIdentifier("Generateur de Rapport")
                );

        DeviceType type =
                new UDADeviceType("Bureau", 1);

        DeviceDetails details =
                new DeviceDetails(
                        "Generateur de rapport",					// Friendly Name
                        new ManufacturerDetails(
                                "UPS-IRIT",								// Manufacturer
                                ""),								// Manufacturer URL
                        new ModelDetails(
                                "GenRapport",						// Model Name
                                "Composant qui génère un rapport par rapport à un vote",	// Model Description
                                "v1" 								// Model Number
                        )
                );
        LocalService<GenerationRapportController> generationRapportService =
                new AnnotationLocalServiceBinder().read(GenerationRapportController.class);
        generationRapportService.setManager(
                new DefaultServiceManager(generationRapportService, GenerationRapportController.class)
        );

        new FenetrePrincipale(generationRapportService).setVisible(true);

        return new LocalDevice(
                identity, type, details,
                new LocalService[] {generationRapportService}
        );
    }
}
