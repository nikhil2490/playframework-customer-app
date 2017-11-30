package controllers;

import models.Customer;
import models.ResponseDTO;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.PagedList;
import com.fasterxml.jackson.databind.JsonNode;

public class CustomerController extends Controller {

	// all customer
	public Result index(Integer page) {
		// List<Customer> customers = Customer.find.all();

		PagedList<Customer> findPagedList = Ebean.find(Customer.class)
				.findPagedList(page, 2);
		return ok(Json.toJson(findPagedList.getList()));

	}

	public Result create() {
		JsonNode json = request().body().asJson();
		System.out.println(json);
		ResponseDTO response = new ResponseDTO();
		if (json == null) {
			response.setStatus(false);
			response.setMessage("data can not be blank");
			return ok(Json.toJson(response));
		}
		Customer customer = Json.fromJson(json, Customer.class);
		/*Customer cust = Customer.find.where().orderBy("order by id desc")
				.setMaxRows(1).findUnique();
		customer.setId(cust.getId() + 1);*/
		customer.save();
		response.setStatus(true);
		response.setMessage("save success");
		return ok(Json.toJson(response));
	}

	/*
	 * public Result save() { return TODO; }
	 */

	/*
	 * public Result edit(Integer id) { return TODO; }
	 */

	public Result update() {
		JsonNode json = request().body().asJson();
		ResponseDTO response = new ResponseDTO();
		if (!json.has("id")) {
			response.setStatus(false);
			response.setMessage("incorrect input");
			return ok(Json.toJson(response));
		}
		Customer customer = Json.fromJson(json, Customer.class);
		Customer customerDb = Customer.find.byId(customer.getId());
		if (customerDb == null) {
			response.setStatus(false);
			response.setMessage("no customer with id:" + customer.getId());
			return ok(Json.toJson(response));
		}
		customer.update();
		response.setStatus(true);
		response.setMessage("update success");
		return ok(Json.toJson(response));
	}

	public Result delete(Integer id) {
		Customer customer = Customer.find.byId(id);
		ResponseDTO response = new ResponseDTO();
		if (customer == null) {
			response.setStatus(false);
			response.setMessage("no customer with id:" + id);
			return ok(Json.toJson(response));
		}
		customer.delete();
		response.setStatus(true);
		response.setMessage("delete success");
		return ok(Json.toJson(response));
	}

	/*
	 * public Result show(Integer id) { return TODO; }
	 */

}
