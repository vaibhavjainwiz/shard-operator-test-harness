# shard-operator-test-harness

This is an test harness meant for testing the shard operator addon. It does the following:

* Tests for the existence of the bridgeexecutors.com.redhat.service.bridge CRD. This should be present if the shard
  operator addon has been installed properly.
* Writes out a junit XML file with tests results to the /test-run-results directory as expected
  by the [https://github.com/openshift/osde2e](osde2e) test framework.
* Writes out an `addon-metadata.json` file which will also be consumed by the osde2e test framework.
