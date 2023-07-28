class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        for (int i = 0; i < (1 << requests.length); i++) {
            int[] count = new int[n];
            int j = 0;
            for (int k = i; k > 0; k >>= 1) {
                if ((k & 1) == 1) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                }
                j++;
            }
            if (IntStream.of(count).allMatch(x -> x == 0)) {
                max = Math.max(max, Integer.bitCount(i));
            }
        }
        return max;
    }
}