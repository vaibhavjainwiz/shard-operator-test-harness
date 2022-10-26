FROM registry.ci.openshift.org/openshift/release:golang-1.13 AS builder

ENV PKG=/go/src/github.com/5733d9e2be6485d52ffa08870cabdee0/shard-operator-test-harness/
WORKDIR ${PKG}

# compile test binary
COPY . .
RUN make

FROM registry.access.redhat.com/ubi7/ubi-minimal:latest

COPY --from=builder /go/src/github.com/5733d9e2be6485d52ffa08870cabdee0/shard-operator-test-harness/shard-operator-test-harness.test shard-operator-test-harness.test

ENTRYPOINT [ "/shard-operator-test-harness.test" ]

