class Solution {
    public int minMoves(int[] nums, int k) {
        
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                index.add(i);
            }
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = index.get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < index.size() - k + 1; i++) {
            int mid = i + k / 2;
            int cur = 0;
            for (int j = i; j < i + k; j++) {
                cur += Math.abs(arr[j] - arr[mid]) - Math.abs(j - mid);
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}