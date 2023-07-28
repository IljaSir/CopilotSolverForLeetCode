class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int res = 0;
        char[] chars = brokenLetters.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        String[] words = text.split(" ");
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
}