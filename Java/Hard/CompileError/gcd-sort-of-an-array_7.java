class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int[] parent = new int[100001];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 2; i < parent.length; i++) {
            for (int j = 2 * i; j < parent.length; j += i) {
                union(parent, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, nums[i]) != find(parent, sorted[i])) {
                return false;
            }
        }
        return true;
    }
    
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}