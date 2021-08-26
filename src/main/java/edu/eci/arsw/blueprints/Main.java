package edu.eci.arsw.blueprints;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        Point[] points = new Point[]{new Point(5,5), new Point(7,7)};
        Blueprint blueprint = new Blueprint("Mario","Satanas",points);
        try {
            bs.addNewBlueprint(blueprint);
            Blueprint book =  bs.getBlueprint("Mario","Satanas");
            List<Point> listPoint = book.getPoints();
            listPoint.get(0);
            System.out.println(listPoint.get(2).getY()+" "+listPoint.get(1).getY());
            System.out.println(book.getName());
            Set<Blueprint> set =  bs.getBlueprintsByAuthor("Mario");
            for(Blueprint bp: set){
                System.out.println(bp.getAuthor()+" "+bp.getName());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
