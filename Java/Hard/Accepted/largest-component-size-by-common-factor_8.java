class Solution {
    public int largestComponentSize(int[] nums) {
        
        int N = nums.length;
        int[] parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < N; ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
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

        int[] count = new int[N];
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            int root = find(parent, i);
            count[root]++;
            ans = Math.max(ans, count[root]);
        }
        return ans;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}