class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] bits = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        Integer[] indices = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> {
            if (bits[arr[i1]] != bits[arr[i2]]) {
                return bits[arr[i1]] - bits[arr[i2]];
            } else {
                return arr[i1] - arr[i2];
            }
        });
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[indices[i]];
        }
        return ans;
    }
}