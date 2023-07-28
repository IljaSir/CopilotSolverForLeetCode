class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        int[] counts = new int[10001];
        int max = 0;
        for (int barcode : barcodes) {
            counts[barcode]++;
            if (counts[barcode] > counts[max]) {
                max = barcode;
            }
        }
        int[] result = new int[barcodes.length];
        int index = 0;
        while (counts[max] > 0) {
            result[index] = max;
            index += 2;
            counts[max]--;
        }
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = i;
                index += 2;
                counts[i]--;
            }
        }
        return result;
    }
}