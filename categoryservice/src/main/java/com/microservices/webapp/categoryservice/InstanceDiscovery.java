package com.microservices.webapp.categoryservice;
import java.util.Collection;
import com.netflix.turbine.aggregator.InstanceKey;

public interface InstanceDiscovery {
	public Collection<InstanceKey> getInstanceList() throws Exception;
}

