#!/bin/bash
swagger-codegen generate --api-package io.openbouquet.v4.api --artifact-id java-api --group-id openbouquet --artifact-version 4.2.30 -l java -i https://api.squidsolutions.com/staging/v4.2/swagger.json
