class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        int result = 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            int left = 0, right = result;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < envelopes[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = envelopes[i][1];
            if (left == result) {
                result++;
            }
        }
        return result;
    }
}