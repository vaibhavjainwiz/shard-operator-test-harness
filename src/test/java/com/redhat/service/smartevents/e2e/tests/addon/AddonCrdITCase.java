package com.redhat.service.smartevents.e2e.tests.addon;

import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfig;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

public class AddonCrdITCase {

    private static DefaultOpenShiftClient client = new DefaultOpenShiftClient(new OpenShiftConfig(Config.autoConfigure(null)));

    @DisplayName("crd should have been created:")
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            "bridgeexecutors.com.redhat.service.bridge",
            "bridgeingresses.com.redhat.service.bridge",
    })
    public void crdShouldHaveBeenCreated(String crdName) {
        Awaitility.await()
                .atMost(Duration.ofMinutes(3))
                .untilAsserted(() -> {
                            CustomResourceDefinition crd = client.apiextensions().v1().customResourceDefinitions().withName(crdName).get();
                            Assertions.assertNotNull(crd, () -> crdName + " CRD not created");
                        }
                );
    }

}
