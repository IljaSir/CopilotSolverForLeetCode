class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int n = barcodes.length;
        int[] count = new int[10001];
        for (int i = 0; i < n; i++) {
            count[barcodes[i]]++;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < 10001; i++) {
            if (count[i] > max) {
                max = count[i];
                maxIndex = i;
            }
        }
        int[] ans = new int[n];
        int index = 0;
        while (count[maxIndex] > 0) {
            ans[index] = maxIndex;
            index += 2;
            count[maxIndex]--;
        }
        for (int i = 0; i < 10001; i++) {
            while (count[i] > 0) {
                if (index >= n) {
                    index = 1;
                }
                ans[index] = i;
                index += 2;
                count[i]--;
            }
        }
        return ans;
    }
}