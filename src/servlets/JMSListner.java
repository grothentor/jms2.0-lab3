package servlets;

import constants.Constants;
import services.Receiver;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JMSListner extends HttpServlet {
    @Inject
    private Receiver receiver;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!receiver.receive()) {
            request.setAttribute(Constants.ERROR, "no new messages");
        }

        request.setAttribute(Constants.MESSAGES, receiver.getMessages());
        getServletContext().getRequestDispatcher("/messages.jsp").forward(request, response);
    }
}
