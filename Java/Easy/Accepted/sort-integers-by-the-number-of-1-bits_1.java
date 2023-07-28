class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] arr1 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        Arrays.sort(arr1, (a, b) -> {
            int c1 = Integer.bitCount(a);
            int c2 = Integer.bitCount(b);
            if (c1 != c2) {
                return c1 - c2;
            } else {
                return a - b;
            }
        });
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr1[i];
        }
        return res;
    }
}