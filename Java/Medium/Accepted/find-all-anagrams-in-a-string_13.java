class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] charCount = new int[26];
        for (char c: p.toCharArray()) {
            charCount[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            charCount[s.charAt(end) - 'a']--;
            while (charCount[s.charAt(end) - 'a'] < 0) {
                charCount[s.charAt(start) - 'a']++;
                start++;
            }
            if (end - start + 1 == p.length()) {
                result.add(start);
            }
            end++;
        }
        return result;
    }
}