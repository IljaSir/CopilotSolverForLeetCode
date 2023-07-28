class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            if (data[i] >> 7 == 0) {
                i++;
                continue;
            }
            int count = 0;
            int mask = 1 << 7;
            while ((data[i] & mask) != 0) {
                count++;
                mask >>= 1;
            }
            if (count == 1 || count > 4) {
                return false;
            }
            int j = i + 1;
            while (j < i + count) {
                if (j >= n || (data[j] >> 6) != 2) {
                    return false;
                }
                j++;
            }
            i += count;
        }
        return true;
    }
}