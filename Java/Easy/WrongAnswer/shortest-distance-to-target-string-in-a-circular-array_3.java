class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
        for (int i = startIndex - 1; i >= 0; i--) {
            if (words[i].equals(target)) {
                prev[i] = i;
            } else {
                prev[i] = prev[(i + 1) % n];
            }
        }
        for (int i = startIndex + 1; i < n; i++) {
            if (words[i].equals(target)) {
                next[i] = i;
            } else {
                next[i] = next[(i - 1 + n) % n];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prev[i] != -1) {
                min = Math.min(min, Math.abs(prev[i] - startIndex));
            }
            if (next[i] != -1) {
                min = Math.min(min, Math.abs(next[i] - startIndex));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}