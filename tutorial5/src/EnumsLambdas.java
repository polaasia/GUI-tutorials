import java.util.Arrays;
import java.util.Comparator;

public class EnumsLambdas {

    static <T> void printArray(String msg, T[]arr){
        System.out.println(msg);
        for (T a : arr){
            System.out.println( a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Max", Sex.M, Size.XL, Country.NL),
                new Person("Jan", Sex.M, Size.S, Country.PL),
                new Person("Eva", Sex.F, Size.XS, Country.NL),
                new Person("Lina", Sex.F, Size.L, Country.DE),
                new Person("Mila", Sex.F, Size.S, Country.DE),
                new Person("Ola", Sex.F, Size.M, Country.PL),
        };
        Comparator<Person> sexThenSize = (p1, p2) ->{
            int d = p1.sex.ordinal() - p2.sex.ordinal();
            if(d == 0 ){
             d =p1.size.ordinal() - p2.size.ordinal();
            }
           return d;
        };
        Arrays.sort(persons, sexThenSize);
        printArray("Persons by sex and then size", persons);

        Comparator<Person> sizeThenName = (p1, p2) ->{
            int d = p1.size.ordinal() - p2.size.ordinal();
            if(d == 0 ){
                d = p1.name.compareTo(p2.name);
            }
            return d;
        };
        Arrays.sort(persons, sizeThenName);
        printArray("Persons by size and then name", persons);


        Country[] countries = Country.values();
        Comparator<Country> compareCountries = (c1, c2) ->{
            int d = c1.name().compareTo(c2.name());
            return d;
        };


        Arrays.sort(countries, compareCountries );
        printArray("Countries by name", countries);
    }
}

 enum Sex {F, M}
 enum Size {XS, S, M, L, XL}
 enum Country {NL{
     @Override
     public String toString(){return "Nederland";};
            }, PL{
     @Override
     public String toString(){return "Polska";};
            }, DE{
     @Override
     public String toString(){return "Deutschland";};
        }}

 class Person{
    public String name;
    public Sex sex;
    public Size size;
    public Country country;

    public Person(String name, Sex sex, Size size, Country country ){
        this.name = name;
        this.sex = sex;
        this.size = size;
        this.country = country;
    }


    @Override
     public String toString(){
        return name + " (" + sex + ", " + size + ", " + country + ")";
    }





 }