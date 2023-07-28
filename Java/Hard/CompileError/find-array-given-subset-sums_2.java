class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] ans = new int[n];
        Arrays.sort(sums);
        int[] sums2 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums2[i] = sums[i];
        }
        int[] sums3 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums3[i] = sums[i];
        }
        for (int i = 1; i < sums.length; i++) {
            sums[i] += sums[i - 1];
        }
        for (int i = 1; i < sums.length; i++) {
            sums2[i] += sums2[i - 1];
        }
        for (int i = 1; i < sums.length; i++) {
            sums3[i] += sums3[i - 1];
        }
        int[] sums4 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums4[i] = sums[i];
        }
        int[] sums5 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums5[i] = sums[i];
        }
        int[] sums6 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums6[i] = sums[i];
        }
        int[] sums7 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums7[i] = sums[i];
        }
        int[] sums8 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums8[i] = sums[i];
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums.length; j++) {
                if (i != j) {
                    sums4[i] -= sums[j];
                }
            }
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums.length; j++) {
                if (i != j) {
                    sums5[i
    }
}