class Solution {
    public int reinitializePermutation(int n) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] perm = new int[n];
        int[] arr2 = new int[n];
        int count = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr2[i] = arr[i / 2];
                } else {
                    arr2[i] = arr[n / 2 + (i - 1) / 2];
                }
            }
            count++;
            if (Arrays.equals(arr2, perm)) {
                return count;
            }
            System.arraycopy(arr2, 0, arr, 0, n);
        }
    }
}