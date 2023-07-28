class Solution {
    public int numDifferentIntegers(String word) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))) j++;
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
}