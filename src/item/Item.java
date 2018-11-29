package item;

public class Item {
	String name;
    int level;
    String classChar;

    public Item(String name, int lvl, String classChar) {
        this.name = name;
        this.level = lvl;
        this.classChar = classChar;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getClassChar() {
        return this.classChar;
    }

    public void setClassChar(String classChar) {
        this.classChar = classChar;
    }
}
