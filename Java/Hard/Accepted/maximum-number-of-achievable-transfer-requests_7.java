class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int max = 0;
        for (int i = 0; i < 1 << requests.length; i++) {
            int[] count = new int[n];
            int k = 0;
            for (int j = 0; j < requests.length; j++) {
                if ((i & (1 << j)) > 0) {
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                    k++;
                }
            }
            if (Arrays.stream(count).allMatch(x -> x == 0)) {
                max = Math.max(max, k);
            }
        }
        return max;
    }
}