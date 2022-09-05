package com.microservices.buffercode.cloudgateway;

import java.util.Collection;

import com.netflix.turbine.aggregator.InstanceKey;
//import com.netflix.turbine.discovery.Instance;

public interface InstanceDiscovery {
	public Collection<InstanceKey> getInstanceList() throws Exception;
}
