
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Warrior warrior = new Warrior("warrior", 20, 100, 10);
        Mage mage = new Mage("mage", 25, 80, 5);
        Archer archer = new Archer("archer", 18, 90, 8);

        ArrayList<Character> list = new ArrayList<>();
        list.add(warrior);
        list.add(mage);
        list.add(archer);

        HashMap<String, Integer> scoreBoard = new HashMap<>();
        scoreBoard.put("warrior", 0);
        scoreBoard.put("mage", 0);
        scoreBoard.put("archer", 0);

        BattleArena arena = new BattleArena();
        arena.startBattle(warrior, mage, scoreBoard);

        System.out.println("\n--- FINAL STATUS ---");
        for (Character c : list) {
            c.displayStatus();
        }

        System.out.println("\n--- SCOREBOARD ---");
        System.out.println(scoreBoard);
    }
}

interface SpecialAbility {

    void specialAttack(Character enemy);
}

class BattleArena {

    Random random = new Random();

    void startBattle(Character c1, Character c2, HashMap<String, Integer> scoreBoard) {

        int round = 1;

        while (c1.health > 0 && c2.health > 0) {

            System.out.println("\nRound: " + round);

            // C1 TURN
            if (random.nextInt(100) < 30 && c1 instanceof SpecialAbility) {
                ((SpecialAbility) c1).specialAttack(c2);
                System.out.println(c1.name + " used SPECIAL ATTACK!");
            } else {
                c1.attack(c2);
            }

            if (c2.health <= 0) {
                break;
            }

            // C2 TURN
            if (random.nextInt(100) < 30 && c2 instanceof SpecialAbility) {
                ((SpecialAbility) c2).specialAttack(c1);
                System.out.println(c2.name + " used SPECIAL ATTACK!");
            } else {
                c2.attack(c1);
            }

            c1.displayStatus();
            c2.displayStatus();

            round++;
        }

        // WINNER
        if (c1.health > 0) {
            System.out.println("\n " + c1.name + " WINS!");
            scoreBoard.put(c1.name, scoreBoard.get(c1.name) + 1);
        } else {
            System.out.println("\n" + c2.name + " WINS!");
            scoreBoard.put(c2.name, scoreBoard.get(c2.name) + 1);
        }
    }
}

abstract class Character {

    String name;
    int attackPower;
    int health;
    int defense;

    Character(String name, int attackPower, int health, int defense) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
        this.defense = defense;
    }

    abstract void attack(Character enemy);

    void takeDamage(int damage) {
        health = health - damage;
    }

    void displayStatus() {
        System.out.println(name + " Health: " + health);
    }
}

class Warrior extends Character implements SpecialAbility {

    Warrior(String name, int attackPower, int health, int defense) {
        super(name, attackPower, health, defense);
    }

    public void attack(Character enemy) {
        int damage = attackPower - enemy.defense;
        enemy.takeDamage(damage);
    }

    public void specialAttack(Character enemy) {
        int damage = attackPower * 2;
        enemy.takeDamage(damage);
    }
}

class Mage extends Character implements SpecialAbility {

    Mage(String name, int attackPower, int health, int defense) {
        super(name, attackPower, health, defense);
    }

    public void attack(Character enemy) {
        int damage = attackPower - enemy.defense;
        enemy.takeDamage(damage);
    }

    public void specialAttack(Character enemy) {
        int damage = attackPower + 10;
        enemy.takeDamage(damage);
    }
}

class Archer extends Character implements SpecialAbility {

    Archer(String name, int attackPower, int health, int defense) {
        super(name, attackPower, health, defense);
    }

    public void attack(Character enemy) {
        int damage = attackPower - enemy.defense;
        enemy.takeDamage(damage);
    }

    public void specialAttack(Character enemy) {
        int damage = attackPower + 5;
        enemy.takeDamage(damage);
    }
}
