class Solution {
    public boolean validUtf8(int[] data) {
        
        int i = 0;
        while (i < data.length) {
            int mask = 1 << 7;
            int count = 0;
            while ((data[i] & mask) != 0) {
                count++;
                mask >>= 1;
            }
            if (count == 0) {
                i++;
                continue;
            }
            if (count == 1 || count > 4) {
                return false;
            }
            if (i + count > data.length) {
                return false;
            }
            for (int j = 1; j < count; j++) {
                if ((data[i + j] & (1 << 7)) == 0 || (data[i + j] & (1 << 6)) != 0) {
                    return false;
                }
            }
            i += count;
        }
        return true;
    }
}