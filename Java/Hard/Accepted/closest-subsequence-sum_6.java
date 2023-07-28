class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[n/2];
        int[] right = new int[n - n/2];
        for (int i = 0; i < n/2; i++) {
            left[i] = nums[i];
        }
        for (int i = n/2; i < n; i++) {
            right[i - n/2] = nums[i];
        }
        TreeSet<Integer> leftSum = new TreeSet<>();
        TreeSet<Integer> rightSum = new TreeSet<>();
        leftSum.add(0);
        rightSum.add(0);
        for (int i = 0; i < left.length; i++) {
            TreeSet<Integer> tmp = new TreeSet<>();
            for (int sum : leftSum) {
                tmp.add(sum + left[i]);
            }
            leftSum.addAll(tmp);
        }
        for (int i = 0; i < right.length; i++) {
            TreeSet<Integer> tmp = new TreeSet<>();
            for (int sum : rightSum) {
                tmp.add(sum + right[i]);
            }
            rightSum.addAll(tmp);
        }
        int ans = Math.abs(goal);
        for (int sum : leftSum) {
            int cur = Math.abs(sum - goal);
            if (cur < ans) {
                ans = cur;
            }
            Integer rightSumCeil = rightSum.ceiling(goal - sum);
            if (rightSumCeil != null) {
                cur = Math.abs(sum + rightSumCeil - goal);
                if (cur < ans) {
                    ans = cur;
                }
            }
            Integer rightSumFloor = rightSum.floor(goal - sum);
            if (rightSumFloor != null) {
                cur = Math.abs(sum + rightSumFloor - goal);
                if (cur < ans) {
                    ans = cur;
                }
            }
        }
        return ans;
    }
}