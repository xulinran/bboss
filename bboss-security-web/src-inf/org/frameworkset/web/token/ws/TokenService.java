package org.frameworkset.web.token.ws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.frameworkset.util.annotations.ResponseBody;

@WebService(name = "TokenService", targetNamespace = "org.frameworkset.web.token.ws.TokenService")
public interface TokenService {
	public @WebResult(name = "authTempToken", partName = "partAuthTempToken")
	String genAuthTempToken(
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret,
			@WebParam(name = "ticket", partName = "partTicket") String ticket)
			throws Exception;

	public @WebResult(name = "dualToken", partName = "partDualToken")
	String genDualToken(
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret,
			@WebParam(name = "ticket", partName = "partTicket") String ticket)
			throws Exception;

	
	public @WebResult(name = "tempToken", partName = "partTempToken") String genTempToken() throws Exception;
	public @WebResult(name = "ticket", partName = "partTicket")  
	String genTicket(
			@WebParam(name = "account", partName = "partAccount") String account,
			@WebParam(name = "worknumber", partName = "partWorknumber") String worknumber,
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret)throws Exception;
	
	
	
	public @WebResult(name = "authTempToken", partName = "partAuthTempToken")
	TokenGetResponse getAuthTempToken(
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret,
			@WebParam(name = "ticket", partName = "partTicket") String ticket)
			throws Exception;

	public @WebResult(name = "dualToken", partName = "partDualToken")
	TokenGetResponse getDualToken(
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret,
			@WebParam(name = "ticket", partName = "partTicket") String ticket)
			throws Exception;
	
	public @WebResult(name = "dualToken", partName = "partDualToken") TokenGetResponse getDualTokenWithDefaultLiveTime(@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret,
			@WebParam(name = "ticket", partName = "partTicket") String ticket) throws Exception;

	
	public @WebResult(name = "tempToken", partName = "partTempToken") TokenGetResponse getTempToken() throws Exception;
	public @WebResult(name = "ticket", partName = "partTicket")  
	TicketGetResponse getTicket(
			@WebParam(name = "account", partName = "partAccount") String account,
			@WebParam(name = "worknumber", partName = "partWorknumber") String worknumber,
			@WebParam(name = "appid", partName = "partAppid") String appid,
			@WebParam(name = "secret", partName = "partSecret") String secret)throws Exception;
}