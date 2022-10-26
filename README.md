# Smart events Add-on Test Harness

It does the following:

* Tests for the existence of the fleetshard CRDs:
    * bridgeexecutors.com.redhat.service.bridge
    * bridgeingresses.com.redhat.service.bridge
* Writes out the files expected by the [osde2e](https://github.com/openshift/osde2e) test framework to the `/test-run-results` directory:
    * `junit-report.xml`
    * `addon-metadata.json`

## Running locally

To run the tests locally, build the test image and mount valid kubeconfig file

```
$ docker build -f Dockerfile -t shard-operator-test-harness:latest .
$ docker run --rm -v ~/.kube:/home/jboss/.kube/:z -it shard-operator-test-harness:latest
```
