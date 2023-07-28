class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        int[] removed = new int[n];
        for(int i = 0; i < n; i++){
            removed[removeQueries[i]] = i;
        }
        long[] ans = new long[n];
        long max = 0;
        long sum = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(-1);
        treeSet.add(n);
        for(int i = n - 1; i >= 0; i--){
            int index = removed[i];
            Integer left = treeSet.lower(index);
            Integer right = treeSet.higher(index);
            if(left != null && right != null){
                sum -= (long)(right - left - 1) * nums[index];
            }
            if(left != null){
                sum += (long)(index - left - 1) * nums[index];
            }
            if(right != null){
                sum += (long)(right - index - 1) * nums[index];
            }
            treeSet.add(index);
            max = Math.max(max, sum);
            ans[i] = max;
        }
        return ans;
    }
}