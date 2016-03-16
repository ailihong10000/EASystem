package action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import net.sf.json.JSONObject;
import service.api.AdminService;
import service.api.StudentService;
import service.api.TeacherService;
import util.SecurityCode;
import util.SecurityImage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxLoginAction extends ActionSupport {
	private AdminService as;
	private StudentService ss;
	private TeacherService ts;
	private String username;
	private String password;
	private String verifyCode;
	private String role;
	private String result;
	private Map<String, Object> session;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public AdminService getAs() {
		return as;
	}

	public void setAs(AdminService as) {
		this.as = as;
	}

	public StudentService getSs() {
		return ss;
	}

	public void setSs(StudentService ss) {
		this.ss = ss;
	}

	public TeacherService getTs() {
		return ts;
	}

	public void setTs(TeacherService ts) {
		this.ts = ts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		session = ActionContext.getContext().getSession();
		if (password.length() < 8 || password.length() > 30) {
			loginFail("密码格式错误或有非法字符 *");
			return ERROR;
		} else if (username.length() < 8 || username.length() > 30) {
			loginFail("用户名格式错误或有非法字符*");
			return ERROR;
		} else if (!verifyCode.equals(session.get("verifyCode"))) {
			loginFail("验证码错误*");
			return ERROR;
		} else {

			if (role.equals("admin")) {
				if (as.login(username, password)) {
					loginSuccess(role);
					return SUCCESS;
				}
			} else if (role.equals("student")) {
				if (ss.login(username, password)) {
					loginSuccess(role);
					return SUCCESS;
				}
			} else if (role.equals("teacher")) {
				if (ts.login(username, password)) {
					loginSuccess(role);
					return SUCCESS;
				}
			}
		}
		loginFail("账号或密码错误*");
		return ERROR;
		/*
		 * Map<String,Object> map = new HashMap<String,Object>();
		 * map.put("username", username); map.put("password",password);
		 * map.put("securityCode", securityCode); map.put("role", role);
		 * JSONObject json=new JSONObject(); json=JSONObject.fromObject(map);
		 * result = json.toString();//给result赋值，传递给页面
		 */
	}

	private void loginFail(String message) {
		ActionContext.getContext().getSession()
				.put("verifyCode", SecurityCode.getSecurityCode());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginResult", false);
		map.put("message", message);
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(map);
		result = json.toString();
	}

	private void loginSuccess(String role) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginResult", true);
		map.put("message", "登录成功*");
		map.put("url", role + "Action");
		JSONObject json = new JSONObject();
		json = JSONObject.fromObject(map);
		result = json.toString();
		session.put("username", username);
		session.put("role", role);
	}

}
