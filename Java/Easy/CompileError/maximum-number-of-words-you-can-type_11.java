class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        it res = 0;
        char[]hars = brokenLetters.tCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        String[] words = text.split(" ");
        for (String word : words) {
            boolean flag = tre;
            for (char c : word.toCharArray()) {
                if (set.contais(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        reurn res
        return result;
    }
}