package Pirate;

import java.util.List;

public class Pirates {

    List<Pirates> piratesAll;
    String name;
    int intoxicated;
    boolean awake = true;
    boolean alive = true;
    boolean parrot = false;
    boolean captain = false;





    Pirates() {
        int a = (int)(Math.random()*100);
        intoxicated = (int)(Math.random()*5);
        if(a<20) {
            this.awake = true;
            this.parrot = true;
        } else if (a<50) {
            awake = false;
        }
    }

    Pirates(String name) {
        this.name = name;

        int a = (int)(Math.random()*100);
        intoxicated = (int)(Math.random()*5);
        if(a<20) {
            this.awake = true;
            this.parrot = true;
        } else if (a<50) {
            awake = false;
        }
    }

    void drinkSomeRum() {
        if (this.alive) {
            this.intoxicated++;
        } else {
            System.out.println(this.name + " dead");
        }
        intoxicatedSleep();
    }

    void intoxicatedSleep() {
        if (this.intoxicated > 4) {
            this.awake = false;
        }
    }

    void howsItGoingMate() {
        if (this.alive) {
            if(this.intoxicated < 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
            }
            this.awake = false;
        } else {
            System.out.println(this.name + " dead");
        }

    }

    void die() {
        alive = false;
    }


    void brawl(Pirates pirate) {
        int a = (int)(Math.random()*100);
        if (this.alive && pirate.alive) {
            if (a < 33) {
                this.alive = false;
            } else if (a > 66) {
                pirate.alive = false;
            } else {
                this.awake = false;
                pirate.awake = false;
            }
        } else if (this.alive) {
            System.out.println(pirate.name + "can't brawl, dead");
        } else if (pirate.alive) {
            System.out.println(this.name + " can't brawl, dead");
        } else {
            System.out.println(pirate.name + this.name + " both dead");
        }
    }

    void getParrot() {
        this.parrot = true;
    }

    void makeCaptain() {
        this.captain = true;
    }





}
