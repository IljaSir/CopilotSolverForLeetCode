class Solution {
    public int numDifferentIntegers(String word) {
        
        String[] words = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (String w : words) {
            if (w.length() == 0) continue;
            int i = 0;
            while (i < w.length() && w.charAt(i) == '0') i++;
            set.add(w.substring(i));
        }
        return set.size();
    }
}