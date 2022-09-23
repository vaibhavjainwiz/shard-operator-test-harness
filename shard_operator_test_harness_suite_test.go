package shard_operator_test_harness

import (
	"path/filepath"
	"testing"

	"github.com/5733d9e2be6485d52ffa08870cabdee0/shard-operator-test-harness/pkg/metadata"
	. "github.com/onsi/ginkgo"
	"github.com/onsi/ginkgo/reporters"
	. "github.com/onsi/gomega"

	_ "github.com/5733d9e2be6485d52ffa08870cabdee0/shard-operator-test-harness/pkg/tests"
)

const (
	testResultsDirectory = "/test-run-results"
	jUnitOutputFilename  = "junit-shard-operator.xml"
	addonMetadataName    = "addon-metadata.json"
)

func TestShardOperatorTestHarness(t *testing.T) {
	RegisterFailHandler(Fail)
	jUnitReporter := reporters.NewJUnitReporter(filepath.Join(testResultsDirectory, jUnitOutputFilename))

	RunSpecsWithDefaultAndCustomReporters(t, "Smart Event Shard Operator Test Harness", []Reporter{jUnitReporter})

	err := metadata.Instance.WriteToJSON(filepath.Join(testResultsDirectory, addonMetadataName))
	if err != nil {
		t.Errorf("error while writing metadata: %v", err)
	}
}
