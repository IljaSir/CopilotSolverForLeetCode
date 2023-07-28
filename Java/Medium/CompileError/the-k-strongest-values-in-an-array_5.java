class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        ist m = arr[(arr.length - 1) / 2];
        Arrays.sort(arr, (a, b) -> {
            int d1 = Math.abs(a - m);
            int d2 = Math.abs(b - m);
            if (d1 != d2) {
                return d2 - d1;
            }
            return b - a;
        });
        return Arrays.copyOfRange(arr, 0, k);
    }
}