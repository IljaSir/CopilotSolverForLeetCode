class Solution {
    public int countWords(String[] words1, String[] words2) {
        
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();
        for (int i = 0; i < words1.length; i++) {
            if (!set1.contains(words1[i])) {
                set1.add(words1[i]);
            } else {
                set2.add(words1[i]);
            }
        }
        for (int i = 0; i < words2.length; i++) {
            if (!set3.contains(words2[i])) {
                set3.add(words2[i]);
            } else {
                set4.add(words2[i]);
            }
        }
        int count = 0;
        for (String s : set1) {
            if (!set3.contains(s) && !set4.contains(s)) {
                count++;
            }
        }
        for (String s : set3) {
            if (!set1.contains(s) && !set2.contains(s)) {
                count++;
            }
        }
        return count;
    }
}