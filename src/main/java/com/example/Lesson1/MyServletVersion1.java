package com.example.Lesson1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "MyServlet", urlPatterns = {"/servlet"})
public class MyServletVersion1 extends HttpServlet {

    private List<Product> products = new CopyOnWriteArrayList<>(); //по совету с прошлого урока.
    private void test(){
        for (int i = 0; i < 10; i++) {
            int coast = new Random().nextInt(1000);
            String txt = "product number" + (i + 1);
            Product product = new Product(i+1, txt,coast);
            products.add( i, product);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        test();
        for (int i = 0; i < 10; i++) {
            resp.getWriter().write("<h2> "+ "id: "+products.get(i).getId() +
                    " title: " + products.get(i).getTitle()+
                    " coast: " + products.get(i).getCost() + " </h2>");
        }
    }


}
