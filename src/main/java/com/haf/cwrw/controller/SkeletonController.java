package com.haf.cwrw.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.haf.cwrw.model.SkeletonModel;
import com.haf.cwrw.service.SkeletonService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("skeleton")
@Api(value = "/skeleton", description = "Product Operations")
@Controller
public class SkeletonController {

	private static Log log = LogFactory.getLog(SkeletonController.class);
	private static final String ALL = "*";
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

	private static final String ACCESS_CONTROL_HEADERS = "Content-Type, Accept, X-Requested-With";
	private static final String ACCESS_CONTROL_METHODS = "POST, GET, PUT, UPDATE, DELETE, OPTIONS";
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

	@Autowired
	private SkeletonService skeletonService;

	// public ProductController(ProductService productService,
	// ErrorMessageResolver errorMessageResolver)
	// {
	// this.productService = productService;
	// this.errorMessageResolver = errorMessageResolver;
	// }

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "get skeleton by id", notes = "Returns the product with the id", response = SkeletonModel.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Missing parameters") })
	public Response getSkeletonById(
			@ApiParam(value = "id of the skeletion", required = true) @PathParam("id") long skeletonId)
			throws Exception {

		SkeletonModel model = skeletonService.getSkeletonById(skeletonId);
		return Response.ok(model).header(ACCESS_CONTROL_ALLOW_ORIGIN, ALL).build();

	}

	public void setSkeletonService(SkeletonService skeletonService) {
		this.skeletonService = skeletonService;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Register User", notes = "Registers a new user to the system", response = SkeletonModel.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Missing parameters") })
	public Response registerUser(
			@ApiParam(value = "name", required = true) @FormParam("name") String name,
			@ApiParam(value = "description", required = false) @DefaultValue("default description") @FormParam("description") String description) {

		SkeletonModel skeleton = skeletonService.registerSkeleton(name, description);

		return Response.ok(skeleton).header(ACCESS_CONTROL_ALLOW_ORIGIN, ALL).build();
	}

}