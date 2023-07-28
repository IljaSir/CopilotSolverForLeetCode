class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (String num : nums) {
                pq.add(Integer.parseInt(num.substring(0, trim)));
            }
            while (k > 1) {
                pq.poll();
                k--;
            }
            ans[i] = pq.poll();
        }
        return ans;
    }
}