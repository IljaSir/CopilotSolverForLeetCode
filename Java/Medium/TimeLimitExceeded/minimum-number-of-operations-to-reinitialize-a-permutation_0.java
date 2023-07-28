class Solution {
    public int reinitializePermutation(int n) {
        
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] arr = new int[n];
        int count = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            count++;
            if (Arrays.equals(arr, perm)) {
                break;
            }
            for (int i = 0; i < n; i++) {
                perm[i] = arr[i];
            }
        }
        return count;
    }
}