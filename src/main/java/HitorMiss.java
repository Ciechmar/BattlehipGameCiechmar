public class HitorMiss {

    public static byte hitOrMiss(String shot, String... iloszcZmiennych) {
        byte a = 0;
        for (String zapisaneZmienne : iloszcZmiennych) {
            if (shot.equals(zapisaneZmienne)){
                a = 1;
            }
        }
        return a;
    }

}
