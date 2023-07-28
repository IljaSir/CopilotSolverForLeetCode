class Solution {
    public int closestToTarget(int[] arr, int target) {
        
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            TreeSet<Integer> set2 = new TreeSet<>();
            set2.add(arr[i]);
            for(int x : set) {
                set2.add(x & arr[i]);
            }
            for(int x : set2) {
                ans = Math.min(ans, Math.abs(x - target));
            }
            set = set2;
        }
        return ans;
    }
}