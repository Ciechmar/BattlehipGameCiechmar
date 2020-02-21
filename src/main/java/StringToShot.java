public class StringToShot {
    public static String stringToShot (int i, int j, String ships){
        ships = ships.toUpperCase();
        char a = ships.charAt(i);
        char b = ships.charAt(j);
        StringBuffer sb = new StringBuffer();
        sb.append(a);
        sb.append(b);

        String s = sb.toString();



        return s;
    }
}
