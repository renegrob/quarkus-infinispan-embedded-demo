package io.github.renegrob.infinispan.embedded;

import org.infinispan.protostream.GeneratedSchema;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = {MyCacheEntry.class, MyCacheEntryProducerAdapter.class}, schemaPackageName = "io.github.renegrob.infinispan.embedded")
public interface MySchema extends GeneratedSchema {
}