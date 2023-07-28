class Solution {
    public int countArrangement(int n) {
        
        int[] count = new int[1];
        countArrangement(n, 1, new boolean[n + 1], count);
        return count[0];
    }
    
    private void countArrangement(int n, int pos, boolean[] used, int[] count) {
        if (pos > n) {
            count[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                countArrangement(n, pos + 1, used, count);
                used[i] = false;
            }
        }
    }
}