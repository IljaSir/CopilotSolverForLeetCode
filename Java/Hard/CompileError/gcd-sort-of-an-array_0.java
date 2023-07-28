class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[100001];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 2; i < parent.length; i++) {
            for (int j = i + i; j < parent.length; j += i) {
                union(parent, i, j);
            }
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, nums[i]) != find(parent, sorted[i])) {
                return false;
            }
        }
        return true;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}