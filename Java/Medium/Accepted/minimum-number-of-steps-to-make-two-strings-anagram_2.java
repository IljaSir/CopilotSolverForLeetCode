class Solution {
    public int minSteps(String s, String t) {
        
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        int result = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                result += counter[i];
            }
        }
        return result;
    }
}