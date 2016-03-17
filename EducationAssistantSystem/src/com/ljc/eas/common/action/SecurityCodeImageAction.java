package com.ljc.eas.common.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.ljc.eas.common.util.SecurityCode;
import com.ljc.eas.common.util.SecurityImage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SecurityCodeImageAction extends ActionSupport {
	private ByteArrayInputStream imageStream;
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}
	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		super.execute();
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String verifyCode=SecurityCode.getSecurityCode();
        BufferedImage image=SecurityImage.createImage(verifyCode);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        ByteArrayInputStream input = new ByteArrayInputStream(outputStream.toByteArray());
        this.setImageStream(input);
        ActionContext.getContext().getSession().put("verifyCode", verifyCode);
        /*HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("checkCode", securityCode);*/
        input.close();
        outputStream.close();
		return SUCCESS;
	}
}
