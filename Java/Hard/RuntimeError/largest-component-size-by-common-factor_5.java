class Solution {
    public int largestComponentSize(int[] nums) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            for (int j = 2; j * j <= num; ++j) {
                if (num % j == 0) {
                    int p = find(parent, i);
                    int q = find(parent, findIndex(nums, j));
                    if (p != q) {
                        parent[p] = q;
                        size[q] += size[p];
                    }
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }
            if (num > 1) {
                int p = find(parent, i);
                int q = find(parent, findIndex(nums, num));
                if (p != q) {
                    parent[p] = q;
                    size[q] += size[p];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, size[find(parent, i)]);
        }
        return ans;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    private int findIndex(int[] nums, int num) {
        int i = 0;
        while (nums[i] != num) {
            ++i;
        }
        return i;
    }
}