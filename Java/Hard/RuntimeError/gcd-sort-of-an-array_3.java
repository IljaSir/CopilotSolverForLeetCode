class Solution {
    public boolean gcdSort(int[] nums) {
        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    union(parent, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (find(parent, i) != find(parent, sorted[i])) {
                return false;
            }
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int i, int j) {
        int pi = find(parent, i);
        int pj = find(parent, j);
        parent[pi] = pj;
    }

    private int gcd(int a, int b) {
        if (a > b) {
            return gcd(b, a);
        }
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}