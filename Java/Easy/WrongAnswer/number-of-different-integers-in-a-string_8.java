class Solution {
    public int numDifferentIntegers(String word) {
        
        int i = 0;
        int j = 0;
        Set<String> set = new HashSet<>();
        while (i < word.length()) {
            if (Character.isDigit(word.charAt(i))) {
                j = i + 1;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                set.add(word.substring(i, j));
                i = j;
            } else {
                i++;
            }
        }
        return set.size();
    }
}