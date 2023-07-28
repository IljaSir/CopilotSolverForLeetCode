class Solution {
    public int largestComponentSize(int[] nums) {
        
        int[] uf = new int[100001];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        for (int num : nums) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    union(uf, num, i);
                    union(uf, num, num / i);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int root = find(uf, num);
            map.put(root, map.getOrDefault(root, 0) + 1);
            max = Math.max(max, map.get(root));
        }
        return max;
    }
    private int find(int[] uf, int i) {
        if (uf[i] != i) {
            uf[i] = find(uf, uf[i]);
        }
        return uf[i];
    }
    private void union(int[] uf, int i, int j) {
        int rootI = find(uf, i);
        int rootJ = find(uf, j);
        if (rootI != rootJ) {
            uf[rootI] = rootJ;
        }
    }
}