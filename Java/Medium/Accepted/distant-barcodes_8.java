class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        // 1. count the frequency of each number
        // 2. sort the frequency
        // 3. fill the array
        int[] count = new int[10001];
        for (int barcode : barcodes) {
            count[barcode]++;
        }
        List<Integer>[] buckets = new List[barcodes.length + 1];
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (buckets[count[i]] == null) {
                    buckets[count[i]] = new ArrayList<>();
                }
                buckets[count[i]].add(i);
            }
        }
        int[] res = new int[barcodes.length];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        res[index] = num;
                        index += 2;
                        if (index >= res.length) {
                            index = 1;
                        }
                    }
                }
            }
        }
        return res;
    }
}