public class LongestName
{
        public static void main(String[] args) {
            String[] nameSib = {"Kofo", "Rotimi", "morenike"};
            findLongestName();

        }

        public static String findLongestName() {
            String[] names = {"Tolu", "Tolani", "tom", "taylor", "Patrick Star"};
            int size = names.length;
            String longestName = names[0];
            for (int i = 1; i < size; i++) {
                if (names[i].length() > longestName.length()) {
                    longestName = names[i];
                }
            }
            System.out.println(longestName);
            return longestName;
        }
}