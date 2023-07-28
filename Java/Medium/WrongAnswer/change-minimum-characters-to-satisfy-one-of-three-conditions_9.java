class Solution {
    public int minCharacters(String a, String b) {
        
        int[] ca = new int[26];
        int[] cb = new int[26];
        int totalA = 0;
        int totalB = 0;
        for (int i = 0; i < a.length(); i++) {
            ca[a.charAt(i) - 'a']++;
            totalA++;
        }
        for (int i = 0; i < b.length(); i++) {
            cb[b.charAt(i) - 'a']++;
            totalB++;
        }
        int min = Integer.MAX_VALUE;
        // condition 1
        for (int i = 0; i < 25; i++) {
            int t = totalA - ca[i] + totalB - cb[i + 1];
            min = Math.min(min, t);
        }
        // condition 2
        for (int i = 1; i < 26; i++) {
            int t = totalA - ca[i] + totalB - cb[i - 1];
            min = Math.min(min, t);
        }
        // condition 3
        int maxA = 0;
        int maxB = 0;
        for (int i = 0; i < 26; i++) {
            maxA = Math.max(maxA, ca[i]);
            maxB = Math.max(maxB, cb[i]);
        }
        min = Math.min(min, totalA - maxA + totalB - maxB);
        return min;
    }
}