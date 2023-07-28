class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] leftCount = new int[n];
        int[] rightCount = new int[n];
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n) {
            if (forts[i] == 0) {
                count++;
            }
            left[i] = count;
            leftCount[i] = i - count;
            i++;
        }
        count = 0;
        while (j >= 0) {
            if (forts[j] == 0) {
                count++;
            }
            right[j] = count;
            rightCount[j] = n - 1 - j - count;
            j--;
        }
        int max = 0;
        for (i = 0; i < n; i++) {
            if (forts[i] == 1) {
                max = Math.max(max, leftCount[i] + right[i]);
                max = Math.max(max, left[i] + rightCount[i]);
            }
        }
        return max;
    }
}