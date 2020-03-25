public abstract class Singer {
    String name;
    int number;
    static int stnum = 1;

    public Singer(String name) {
    this.name = name;
    number = stnum;
    stnum++;
    }

    abstract String sing();

   public static String loudest(Singer[] sng) {
       Singer loudest = null;
       int uppercase = 0;

       for (Singer s : sng) {
           int uc = 0;
           String ly = s.sing();

           for (int i = 0; i < ly.length(); i++) {
               if (Character.isUpperCase(ly.charAt(i))) {
                   uc++;
               }

               if (uc > uppercase) {
                   uppercase = uc;
                   loudest = s;
               }
           }
       }
       return loudest.toString();
   }

    @Override
    public String toString(){
        return "(" + number + ") " + name + ": " + sing();
    }
}