class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        if (s.length() < target.length()) return 0;
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for (char c : s.toCharArray()) {
            sFreq[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            tFreq[c - 'a']++;
        }
        int count = 0;
        while (true) {
            int i = 0;
            for (; i < tFreq.length; i++) {
                if (tFreq[i] == 0) continue;
                if (sFreq[i] == 0) return count;
                sFreq[i]--;
            }
            if (i == tFreq.length) count++;
        }
    }
}