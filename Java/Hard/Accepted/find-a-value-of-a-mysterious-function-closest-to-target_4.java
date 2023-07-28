class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> temp = new HashSet<>();
            temp.add(arr[i]);
            for (int s : set) {
                temp.add(s & arr[i]);
            }
            for (int t : temp) {
                res = Math.min(res, Math.abs(t - target));
            }
            set = temp;
        }
        return res;
    }
}