package fi.vtt.dsp.service.serviceregistry.impl.roa.auth;


import javax.ws.rs.core.Response;


import fi.vtt.dsp.service.serviceregistry.auth.token.AgentRole;
import fi.vtt.dsp.service.serviceregistry.auth.token.AgentType;
import fi.vtt.dsp.service.serviceregistry.common.ServiceRegistryEntry;
import fi.vtt.dsp.service.serviceregistry.common.instance.BindingRequestEndPoint;
import fi.vtt.dsp.service.serviceregistry.common.instance.ServiceInstance;
import fi.vtt.dsp.service.serviceregistry.impl.roa.StaticResourceAuthIT;

public class BindingRequestEndpointResourceAuthIT
		extends
			StaticResourceAuthIT<BindingRequestEndPoint> {

	public BindingRequestEndpointResourceAuthIT() {

		// set expected responses
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.UPD_OWN, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.UPD_OTHER, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);

		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.DEL_OWN, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.OK);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.USER,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.SERVICE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
		setExpectedTestReqStatus(TestReq.DEL_OTHER, AgentType.SERVICE_INSTANCE,
				AgentRole.ROLE_REGISTERED, Response.Status.FORBIDDEN);
	}

	private String getResourcePath(ServiceRegistryEntry service,
			ServiceInstance instance) {
		return String.format(PATH_SERVICE_INSTANCE + "/bindingendpoint",
				service.getServiceId(), instance.getServiceInstanceId());
	}

	@Override
	protected BindingRequestEndPoint getTestResource() {
		return serviceInstanceAgent.getBindingRequestEndPoint();
	}

	@Override
	protected BindingRequestEndPoint getOtherTestResource() {
		return otherServiceInstance.getBindingRequestEndPoint();
	}

	@Override
	protected String getTestResourcePath() {
		return getResourcePath(serviceAgent, serviceInstanceAgent);
	}

	@Override
	protected String getOtherTestResourcePath() {
		return getResourcePath(otherService, otherServiceInstance);
	}

}
