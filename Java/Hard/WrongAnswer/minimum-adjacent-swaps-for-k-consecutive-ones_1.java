class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                list.add(i);
            }
        }

        int m = list.size();
        int[] prefix = new int[m + 1];
        for (int i = 0; i < m; i++) {
            prefix[i + 1] = prefix[i] + list.get(i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k <= m; i++) {
            int mid = i + k / 2;
            ans = Math.min(ans, prefix[mid + 1] - prefix[mid] - (prefix[i + k] - prefix[i + k / 2]) + (prefix[i + k / 2] - prefix[i]) - (prefix[mid] - prefix[i]));
        }
        return ans;
    }
}