class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        if (s.length() < target.length()) {
            return 0;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            counts[target.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] < 0) {
                return 0;
            }
        }
        int[] targetCounts = new int[26];
        for (int i = 0; i < target.length(); i++) {
            targetCounts[target.charAt(i) - 'a']++;
        }
        int result = 0;
        while (true) {
            for (int i = 0; i < 26; i++) {
                if (targetCounts[i] > 0) {
                    if (counts[i] > 0) {
                        counts[i]--;
                        targetCounts[i]--;
                    } else {
                        return result;
                    }
                }
            }
            result++;
        }
    }
}