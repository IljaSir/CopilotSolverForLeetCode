class Solution {
    public int maximumRequests(int n, int[][] requests) {
        
        int[] count = new int[n];
        int max = 0;
        for (int i = 0; i < 1 << requests.length; i++) {
            Arrays.fill(count, 0);
            int total = 0;
            for (int j = 0; j < requests.length; j++) {
                if ((i & (1 << j)) > 0) {
                    total++;
                    count[requests[j][0]]--;
                    count[requests[j][1]]++;
                }
            }
            if (Arrays.stream(count).allMatch(x -> x == 0)) {
                max = Math.max(max, total);
            }
        }
        return max;
    }
}