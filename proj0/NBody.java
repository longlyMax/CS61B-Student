/**
 * @author longlyMax
 * @version 1.0
 */
public class NBody {

    public static void main(String[] args) {
        Double T = Double.valueOf(args[0].toString());
        Double dt = Double.valueOf(args[1].toString());
        String filename = args[2];//读取文件路径，得到宇宙半径和行星数组

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setXscale(radius * (-1.0), radius);
        StdDraw.setYscale(radius * (-1.0), radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");//绘制背景

        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();//让我调用的

        double time = 0.0;

        while (time <= T) {
            double[] xForces = new double[5];
            double[] yForces = new double[5];

            for (int i = 0; i < 5; i++) {
                double exertedByX = planets[i].calcNetForceExertedByX(planets);
                double exertedByY = planets[i].calcNetForceExertedByY(planets);

                xForces[i] = exertedByX;
                yForces[i] = exertedByY;//创建存储净力的数组
            }

            //更新位置
            for (int i = 0; i < 5; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.setXscale(radius * (-1.0), radius);
            StdDraw.setYscale(radius * (-1.0), radius);
            StdDraw.picture(0, 0, "images/starfield.jpg");//绘制背景

            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
    public static double readRadius(String filename) {
        In in = new In(filename);
        int readInt = in.readInt();
        double readDouble = in.readDouble();
        return readDouble;
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int readInt = in.readInt();
        double readDouble = in.readDouble();//去除开头的两个单词

        Planet[] planets = new Planet[5];

        for (int i = 0; i < 5; i++) {
            Planet planet = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            planets[i] = planet;
        }

        return planets;
    }
}
