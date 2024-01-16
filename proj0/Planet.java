/**
 * @author longlyMax
 * @version 1.0
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double gray = 6.6743e-11;
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet planet) {
        this.xxPos =planet.xxPos;
        this.yyPos =planet.yyPos;
        this.xxVel =planet.xxVel;
        this.yyVel =planet.yyVel;
        this.mass = planet.mass;
        this.imgFileName = planet.imgFileName;
    }

    public double calcDistance(Planet planet) {
        double xPos = this.xxPos - planet.xxPos;
        double yPos = this.yyPos - planet.yyPos;
        xPos *= xPos;
        yPos *= yPos;
        double res = xPos + yPos;

        return Math.sqrt(res);
    }

    public double calcForceExertedBy(Planet planet) {
        double force;
        double distance = this.calcDistance(planet);
        force = (gray * this.mass * planet.mass) / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet planet) {
        double flag = 1.0;

        if (this.xxPos > planet.xxPos) {
            flag = -1.0;
        }

        double distance = this.calcDistance(planet);
        double distanceByX = (planet.xxPos - this.xxPos) / distance;
        double force = this.calcForceExertedBy(planet);

        return flag * force * distanceByX;
    }

    public double calcForceExertedByY(Planet planet) {
        double flag = 1.0;

        if (this.yyPos > planet.yyPos) {
            flag = -1.0;
        }

        double distance = this.calcDistance(planet);
        double distanceByY = (planet.yyPos - this.yyPos) / distance;
        double force = this.calcForceExertedBy(planet);

        return flag * force * distanceByY;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0.0;
        double num = 0.0;

        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            num = this.calcForceExertedByX(planet);
            sum += num;
        }

        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0.0;
        double num = 0.0;

        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            num = this.calcForceExertedByY(planet);
            sum += num;
        }

        return sum;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;

        this.xxVel += dt * ax;
        this.yyVel += dt * ay;

        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
