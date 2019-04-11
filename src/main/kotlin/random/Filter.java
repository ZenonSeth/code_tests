package random;

public class Filter {


    public String characters;

    public static void main(String[] args) {

//        Filter applyFilter = new Filter();
//        applyFilter.characters = "abc";
//        System.out.println(applyFilter.applyFilter("abcd", 0, 4, "", 0,0));
//        System.out.println(applyFilter.applyFilter("addddbc", 0, 7, "", 0,0));
//        System.out.println(applyFilter.applyFilter("dddddabcd", 0, 9, "", 0,0));
//        System.out.println(applyFilter.applyFilter("abcddddd", 0, 8, "", 0,0));
//        System.out.println(applyFilter.applyFilter("ddadbdcd", 0, 8, "", 0,0));
    }

    public CharSequence filter(String source, int start, int end, String dest, int dStart, int dEnd) {
        String result = "";
        int validStart = 0;
        for (int i = start; i < end; i++) {
            if (charIsInvalid(source.charAt(i))) {
                result = result + source.subSequence(validStart, i);
                validStart = i + 1;
            }
        }
        if (validStart < end) {
            result = result + source.subSequence(validStart, end);
        }
        return result;
    }

    private boolean charIsInvalid(char c) {
        return characters.indexOf(c) < 0;
    }

}
