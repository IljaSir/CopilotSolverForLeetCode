class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    int x = find(root, i);
                    int y = find(root, j);
                    if (x != y) {
                        if (size[x] > size[y]) {
                            root[y] = x;
                            size[x] += size[y];
                        } else {
                            root[x] = y;
                            size[y] += size[x];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                if (find(root, i) != find(root, Arrays.binarySearch(sorted, nums[i]))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int[] root, int i) {
        if (root[i] != i) {
            root[i] = find(root, root[i]);
        }
        return root[i];
    }
}