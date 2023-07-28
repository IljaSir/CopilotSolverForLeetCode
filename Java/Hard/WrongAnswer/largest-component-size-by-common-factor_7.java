class Solution {
    public int largestComponentSize(int[] nums) {
        
        int N = nums.length;
        int[] uf = new int[N];
        for (int i = 0; i < N; i++) {
            uf[i] = i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    union(i, map.getOrDefault(j, i), uf);
                    union(i, map.getOrDefault(num / j, i), uf);
                    map.put(j, i);
                    map.put(num / j, i);
                }
            }
        }
        int[] count = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, ++count[find(i, uf)]);
        }
        return max;
    }

    private void union(int i, int j, int[] uf) {
        int fi = find(i, uf);
        int fj = find(j, uf);
        if (fi != fj) {
            uf[fi] = fj;
        }
    }

    private int find(int i, int[] uf) {
        if (uf[i] != i) {
            uf[i] = find(uf[i], uf);
        }
        return uf[i];
    }
}