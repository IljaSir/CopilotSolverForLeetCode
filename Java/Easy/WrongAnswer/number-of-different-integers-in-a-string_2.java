class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) >= '0' && word.charAt(j) <= '9') {
                    j++;
                }
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
}