class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] counts = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < len; i++) {
            int idx = chars[i] - 'a';
            counts[idx]++;
            last[idx] = i;
        }
        int start = 0;
        int end = len - 1;
        while (start < end) {
            int idx = chars[start] - 'a';
            if (counts[idx] > repeatLimit) {
                int next = last[idx];
                chars[next] = chars[start];
                chars[start] = (char) ('a' + idx);
                counts[idx]--;
                counts[idx + 1]++;
                last[idx + 1] = next;
                start++;
            } else {
                start++;
            }
        }
        return new String(chars);
    }
}