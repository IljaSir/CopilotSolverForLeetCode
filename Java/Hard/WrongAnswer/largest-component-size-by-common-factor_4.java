class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sqrt = (int) Math.sqrt(num);
            for (int j = 2; j <= sqrt; j++) {
                if (num % j == 0) {
                    int p = find(parent, map.getOrDefault(j, i));
                    int q = find(parent, map.getOrDefault(num / j, i));
                    if (p != q) {
                        parent[p] = q;
                        size[q] += size[p];
                    }
                }
            }
            map.put(num, i);
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, size[find(parent, i)]);
        }
        return ans;
    }

    private int find(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}