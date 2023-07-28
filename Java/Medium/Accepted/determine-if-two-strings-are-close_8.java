class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }
        if (!m1.keySet().equals(m2.keySet())) {
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (char c : word1.toCharArray()) {
            a1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            a2[c - 'a']++;
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}