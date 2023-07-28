class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int[] count = new int[10001];
        int max = 0;
        int maxCount = 0;
        for (int barcode : barcodes) {
            count[barcode]++;
            if (count[barcode] > maxCount) {
                maxCount = count[barcode];
                max = barcode;
            }
        }
        int[] result = new int[barcodes.length];
        int i = 0;
        while (count[max] > 0) {
            result[i] = max;
            count[max]--;
            i += 2;
        }
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                if (i >= result.length) {
                    i = 1;
                }
                result[i] = j;
                count[j]--;
                i += 2;
            }
        }
        return result;
    }
}