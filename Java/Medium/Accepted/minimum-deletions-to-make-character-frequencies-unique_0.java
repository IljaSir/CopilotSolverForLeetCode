class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && !set.add(freq[i])) {
                freq[i]--;
                count++;
            }
        }
        return count;
    }
}