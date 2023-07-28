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
    
    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}