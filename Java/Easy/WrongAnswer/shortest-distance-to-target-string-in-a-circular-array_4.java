class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        
        int n = words.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = startIndex - 1; i >= 0; i--) {
            if (words[i].equals(target)) {
                left[i] = 0;
            } else if (left[(i + 1) % n] != -1) {
                left[i] = left[(i + 1) % n] + 1;
            }
        }
        for (int i = startIndex + 1; i < n; i++) {
            if (words[i].equals(target)) {
                right[i] = 0;
            } else if (right[(i - 1 + n) % n] != -1) {
                right[i] = right[(i - 1 + n) % n] + 1;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (left[i] != -1 && right[i] != -1) {
                ans = Math.min(ans, Math.min(left[i], right[i]));
            } else if (left[i] != -1) {
                ans = Math.min(ans, left[i]);
            } else if (right[i] != -1) {
                ans = Math.min(ans, right[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}