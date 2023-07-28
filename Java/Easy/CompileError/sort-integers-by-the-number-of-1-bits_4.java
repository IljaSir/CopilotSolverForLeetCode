class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] bits = new int[10001];
        for (int i = 0; i < 10001; i++) {
            bits[i] = countBits(i);
        }
        Arrays.sort(arr);
        Arrays.sort(arr, (a, b) -> bits[a] - bits[b]);
        return arr;
    }

    private int countBits(int x) {
        int count = 0;
        while (x > 0) {
            if ((x & 1) == 1) {
                count++;
            }
            x >>= 1;
        }
        return count;
    }
}