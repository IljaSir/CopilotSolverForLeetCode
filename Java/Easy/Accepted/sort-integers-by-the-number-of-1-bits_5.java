class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] bits = new int[10001];
        for (int i = 0; i < 10001; i++) {
            bits[i] = Integer.bitCount(i);
        }
        Integer[] sorted = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted, (a, b) -> {
            if (bits[a] == bits[b]) {
                return a - b;
            }
            return bits[a] - bits[b];
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
        return arr;
    }
}