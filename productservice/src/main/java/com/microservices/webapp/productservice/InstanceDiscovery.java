package com.microservices.webapp.productservice;

import java.util.Collection;

import com.netflix.turbine.aggregator.InstanceKey;

public interface InstanceDiscovery {
	public Collection<InstanceKey> getInstanceList() throws Exception;
}
