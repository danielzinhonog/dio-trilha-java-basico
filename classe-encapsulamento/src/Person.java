import java.time.OffsetDateTime;

public class Person{

    private final String name;
    private int age;
    private int lastYearAgeInc;
    
    public Person(String name){
        this.name = name;
        this.age = 1;
        this.lastYearAgeInc = OffsetDateTime.now().getYear();
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void incAge(){
        int currentYear = OffsetDateTime.now().getYear();
        if(currentYear > lastYearAgeInc){
            this.age++;
            lastYearAgeInc = currentYear;
        }else{
            System.out.println("A idade só pode ser incrementada uma vez por ano.");
        }
    }
}