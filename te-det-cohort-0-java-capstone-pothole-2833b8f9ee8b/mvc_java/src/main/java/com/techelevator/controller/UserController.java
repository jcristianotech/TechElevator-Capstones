package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import com.techelevator.model.Staff;
import com.techelevator.model.StaffDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

//THIS IS THE REAL CONTROLLER

@Controller
public class UserController {
	// ok. so we want this to be able to be empty, as well as store both users and
	// staff.
	// having it just be an object prevents us from calling methods on it.
	// so instead maybe we save a String of its type and the id number.
	// now, you're going to have to call getById methods on loggedInUser[1] based on
	// the text of [0].
	// those methods should work, but i promise nothing
	public static String[] loggedInUser = new String[2];
	@Autowired
	UserDAO userDAO;

	@Autowired
	StaffDAO staffDAO;

	@Autowired
	PotholeDAO potholeDAO;

//	@Autowired
//	WorkOrderDAO workOrderDAO;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Pothole> potholes = potholeDAO.showAllPotholes();
		request.setAttribute("potholes", potholes);
		loggedInUser = new String[2];
		request.setAttribute("loggedInUser", loggedInUser);
		staffDAO.saveStaff("15", "name", "name", "passwordABC", "name@name");
		return "home";
	}

	@RequestMapping(path = "/about", method = RequestMethod.GET)
	public String showAboutPage() {
		return "about";
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/register";
		}
		if (userDAO.saveUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword())) {
			loggedInUser[0] = "user";
			loggedInUser[1] = user.getUserId();
			flash.addFlashAttribute("loggedInUser", loggedInUser);
			return "redirect:/";
		}
		// so it should redirect only on success now.
		return "redirect:register";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginOptions(Model modelHolder) {
		if (!modelHolder.containsAttribute("login")) {
			modelHolder.addAttribute("login", new User());
		}
		return "login";
	}

	@RequestMapping(path = "/userLogin", method = RequestMethod.GET)
	public String showUserLoginForm(Model modelHolder) {
		// System.out.println("in get");
		if (!modelHolder.containsAttribute("userLogin")) {
			modelHolder.addAttribute("userLogin", new User());
		}
		return "userLogin";
	}

	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public String submitUserLoginForm(@Valid @ModelAttribute("userLogin") User user, BindingResult result,
			RedirectAttributes flash) {
		// ok so it should now be matching to a real account
		// System.out.println("in post");
		// if the user.pass and user.email dont match the same sql row, panic.
		// if this doesnt find something, also send them back to userlogin. we might
		// want to give them an error eventually

		// userDAO.searchForEmailAndPassword(user.getEmail(), user.getPassword());
		if (!userDAO.searchForEmailAndPassword(user.getEmail(), user.getPassword())) {
			return "redirect:/userLogin";
		}

		// userDAO.searchForEmailAndPassword(user.getEmail(), user.getPassword());

		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "userLogin", result);
			flash.addFlashAttribute("userLogin", user);
			return "redirect:/userLogin";
		}
		if (!userDAO.searchForEmailAndPassword(user.getEmail(), user.getPassword())) {
			return "redirect:/userLogin";
		}
		loggedInUser[0] = "user";
		loggedInUser[1] = user.getUserId();
		flash.addFlashAttribute("loggedInUser", loggedInUser);
		return "redirect:/";

	}

	@RequestMapping(path = "/staffLogin", method = RequestMethod.GET)
	public String showStaffLoginForm(Model modelHolder) {
		if (!modelHolder.containsAttribute("staffLogin")) {
			modelHolder.addAttribute("staffLogin", new Staff());
		}
		return "staffLogin";
	}

	@RequestMapping(path = "/staffLogin", method = RequestMethod.POST)
	public String submitStaffLoginForm(@Valid @ModelAttribute("staffLogin") Staff staff, BindingResult result,
			RedirectAttributes flash) {
		// so this does work now, but we still need to make sure they're a valid user.
		// staffDAO.searchForStaffIdAndPassword(staff.getStaffId(),
		// staff.getPassword());
		// System.out.println(staff.getPassword());
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "staffLogin", result);
			flash.addFlashAttribute("staffLogin", staff);
			return "redirect:/staffLogin";
		}
		if (!staffDAO.searchForEmailAndPassword(staff.getEmail(), staff.getPassword())) {
			return "redirect:/staffLogin";
		}
		loggedInUser[0] = "staff";
		loggedInUser[1] = staff.getStaffId();
		flash.addFlashAttribute("loggedInUser", loggedInUser);
		return "redirect:/staffHomePage";
		/*
		 * flash.addFlashAttribute("message", "You have successfully logged in.");
		 * return "redirect:/staffHomePage";
		 */

	}

	@RequestMapping(path = "/staffHomePage", method = RequestMethod.GET)
	public String showStaffOptions(Model modelHolder) {
		if (!modelHolder.containsAttribute("login")) {
			modelHolder.addAttribute("login", new Staff());
		}
		return "staffHomePage";
	}

	@RequestMapping(path = "/staffHomePage", method = RequestMethod.POST)
	public String submitStaffOption(@Valid @ModelAttribute("userLogin") Staff loginFormValues, BindingResult result,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "userLogin", result);
			flash.addFlashAttribute("userLogin", loginFormValues);
		}
		return "redirect:/staffHomePage";

	}

	@RequestMapping(path = "/review", method = RequestMethod.GET)
	public String showAllPotholes(HttpServletRequest request, Model modelHolder) {
		List<Pothole> potholes = potholeDAO.showAllPotholes();
		request.setAttribute("potholes", potholes);
		return "review";
	}

//	This needs work
	@RequestMapping(path = "/review", method = RequestMethod.POST)
	public String showAllPotholes(HttpServletRequest request, RedirectAttributes ra) {
		String act = request.getParameter("btn");
		if (act.equals("Delete")) {
			String[] selectedPotholeIds = request.getParameterValues("selected");
			for (String deletedIds : selectedPotholeIds)
				potholeDAO.deletePothole(deletedIds);
			List<Pothole> potholes = potholeDAO.showAllPotholes();
			return "redirect:/review";
		} else if (act.equals("Inspect")) {
			// inspect
			String[] selectedPotholeIds = request.getParameterValues("selected");
			String ids = "?ids=";
			for (String selectedId : selectedPotholeIds) {
				ids += " " + selectedId;
			}
			return "redirect:/inspect" + ids;
			//repair
		} else if (act.equals("Repair")) {
			// inspect
			String[] selectedPotholeIds = request.getParameterValues("selected");
			String ids = "?ids=";
			for (String selectedId : selectedPotholeIds) {
				ids += " " + selectedId;
			}
			return "redirect:/repair" + ids;
		}
		return "redirect:/review";
	}

	@RequestMapping(path = "/inspect", method = RequestMethod.GET)
	public String showAllSelectedPotholes(HttpServletRequest request, @RequestParam String ids) {
		ids = ids.trim();
		String[] idArray = ids.split(" ");
		List<Pothole> potholes = new ArrayList<>();
		for (String i : idArray) {
			Pothole p = (Pothole) potholeDAO.getPotholeById(i);
			potholes.add(p);
		}
		request.setAttribute("inspectedPotholes", potholes);
		return "inspect";
	}

	@RequestMapping(path = "/inspect", method = RequestMethod.POST)
	public String updatePotholesForInspection(HttpServletRequest request, String potholeId, String dateInspection,
			String rank, String description) {
		String[] selectedInspection = request.getParameterValues("selected");
		for (String updateInspectionIds : selectedInspection) {
			potholeDAO.updateInspection(updateInspectionIds, dateInspection, rank, description);
		}
		return "redirect:/review";
	}

	@RequestMapping(path = "/repair", method = RequestMethod.GET)
	public String showAllRepairOrders(HttpServletRequest request, @RequestParam String ids) {
		ids = ids.trim();
		String[] idArray = ids.split(" ");
		List<Pothole> potholes = new ArrayList<>();
		for (String i : idArray) {
			Pothole p = (Pothole) potholeDAO.getPotholeById(i);
			potholes.add(p);
		}
		request.setAttribute("repairOrders", potholes);
		return "repair";
	}

	@RequestMapping(path = "/repair", method = RequestMethod.POST)
	public String updateRepairedPotholes(HttpServletRequest request, String potholeId, String dateRepaired) {
		String[] selectedRepaired = request.getParameterValues("selected");
		for (String updateRepairIds : selectedRepaired)
			potholeDAO.updateRepair(updateRepairIds, dateRepaired);
		return "redirect:/review";
	}

	@RequestMapping(path = "/report", method = RequestMethod.GET)
	public String showReportForm(HttpServletRequest request, Model modelHolder) {
		if (!modelHolder.containsAttribute("report")) {
			modelHolder.addAttribute("report", new Pothole());
		}
		return "report";
	}

//	@RequestMapping(path = "/report", method = RequestMethod.POST)
//	public String submitReportForm(HttpServletRequest request) {
//		
//		return "report";
//	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("currentUser");
		session.invalidate();
		return "redirect:/";
	}

}
