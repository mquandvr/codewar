public class PigIt {

    public static void main(String[] args) {
        System.out.println(pigIt("Hello world !"));
    }

    /**
     * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
     *
     * Examples
     * <pre> {@code
     * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
     * pigIt('Hello world !');     // elloHay orldway !
     * }</pre>
     * @param str
     * @return
     */
    public static String pigIt(String str) {
//        StringBuilder sb = new StringBuilder();
//        if (str == null || str.trim().length() == 0) {
//            return "";
//        }
//        Arrays.stream(str.split(" ")).forEach(s -> {
//            if (s.matches(".*[a-zA-Z].*") ) {
//                sb.append(s.substring(1, s.length()))
//                        .append(s.substring(0, 1))
//                        .append("ay");
//            } else {
//                sb.append(s);
//            }
//            sb.append(" ");
//        });
//        sb.deleteCharAt(sb.length() - 1);

//        return sb.toString();

//        return Arrays.stream(str.split(" "))
//                .map(s -> s.matches("[a-zA-Z]+") ? s.substring(1) + s.substring(0, 1) + "ay" : s)
//                .collect(Collectors.joining(" "))
//                .toString();

        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
