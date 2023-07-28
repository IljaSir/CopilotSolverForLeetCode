class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = nums[i];
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        int res = 0;
        for (int[] edge : edges) {
            int a = find(parent, edge[0]);
            int b = find(parent, edge[1]);
            if (a == b) {
                continue;
            }
            if (size[a] < size[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parent[b] = a;
            sum[a] += sum[b];
            size[a] += size[b];
            if (size[a] == n) {
                return res;
            }
            if (sum[a] % size[a] != 0) {
                res++;
            }
        }
        return -1;
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
    }
}