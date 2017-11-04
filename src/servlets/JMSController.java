package servlets;

import constants.Constants;
import services.Receiver;
import services.Sender;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JMSController extends HttpServlet {
    @Inject
    private Sender sender;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String serviceName = request.getParameter(Constants.SERVICE);
        String errorText = null;
        if (null == serviceName) {
            errorText = "Empty service name!";
        } else {
            switch(serviceName) {
                case Constants.SENDER:
                    String text = request.getParameter(Constants.TEXT);

                    if (null == text || text.isEmpty()) {
                        errorText = "Empty text!";
                    } else {
                        sender.send(text);
                    }
                    break;
                default:
                    errorText = "Invalid service name";
                    break;
            }
        }

        if (null != errorText) {
            request.setAttribute(Constants.ERROR, errorText);
        }

        request.getRequestDispatcher(Constants.HOME).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(Constants.HOME).forward(request, response);
    }
}
