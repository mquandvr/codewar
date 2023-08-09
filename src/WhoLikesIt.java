public class WhoLikesIt {

    private static final String LIKES_IT = " likes this";

    private static final String LIKE_IT = " like this";

    public static void main(String[] args) {
        System.out.println(whoLikesIt());
        System.out.println(whoLikesIt("Peter"));
        System.out.println( whoLikesIt("Jacob", "Alex"));
        System.out.println(whoLikesIt("Max", "John", "Mark"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    /**
     * You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.
     * <br>
     * Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:
     * <br>
     * <pre>{@code
     * []                                -->  "no one likes this"
     * ["Peter"]                         -->  "Peter likes this"
     * ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
     * ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
     * ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
     * }</pre>
     * Note: For 4 or more names, the number in "and 2 others" simply increases.
     * @param names
     * @return
     */
    public static String whoLikesIt(String... names) {
        int namesSize = names.length;

        StringBuilder sb = new StringBuilder();
        switch (namesSize) {
            case 0:
                sb.append("no one").append(LIKES_IT);
                break;
            case 1:
                sb.append(names[0]).append(LIKES_IT);
                break;
            case 2:
                sb.append(String.format("%s and %s", names[0], names[1])).append(LIKE_IT);
                break;
            case 3:
                sb.append(String.format("%s, %s and %s", names[0], names[1], names[2])).append(LIKE_IT);
                break;
            default:
                sb.append(String.format("%s, %s and %s others", names[0], names[1], namesSize - 2)).append(LIKE_IT);
                break;
        }

        return sb.toString();
    }

}
