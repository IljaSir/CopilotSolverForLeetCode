class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : freq) {
            if (i > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        if (min == max) return true;
        for (int i : freq) {
            if (i == max) {
                if (max - min == 1) return true;
                if (min == 1) return true;
            }
            if (i == min) {
                if (max - min == 1) return true;
            }
        }
        return false;
    }
}