#!/bin/bash
swagger-codegen generate --api-package io.bouquet.v4.api --artifact-id bouquet-java-sdk --group-id bouquet --artifact-version 4.2.40 -l java -i https://api.squidsolutions.com/staging/v4.2/swagger.json
