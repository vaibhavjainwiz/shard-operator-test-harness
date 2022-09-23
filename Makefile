DIR := $(dir $(realpath $(firstword $(MAKEFILE_LIST))))
OUT_FILE := "$(DIR)shard-operator-test-harness"

build:
	CGO_ENABLED=0 go test -v -c
