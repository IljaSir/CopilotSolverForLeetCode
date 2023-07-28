class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] sums = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sums[k] += matrix[j][k];
                }
                res += subarraySum(sums, target);
            }
        }
        return res;
    }
    
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}