class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        union(parent, i, map.get(j));
                    }
                    if (!map.containsKey(num / j)) {
                        map.put(num / j, i);
                    } else {
                        union(parent, i, map.get(num / j));
                    }
                }
            }
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                union(parent, i, map.get(num));
            }
        }
        int ans = 0;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[find(parent, i)]++;
            ans = Math.max(ans, count[find(parent, i)]);
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }
}