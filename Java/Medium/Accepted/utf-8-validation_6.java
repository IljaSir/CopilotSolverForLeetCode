class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            int count = 0;
            int x = data[i];
            while ((x & 0x80) != 0) {
                count++;
                x <<= 1;
            }
            if (count == 0) {
                i++;
                continue;
            }
            if (count == 1 || count > 4) {
                return false;
            }
            if (i + count - 1 > n - 1) {
                return false;
            }
            for (int j = i + 1; j < i + count; j++) {
                if ((data[j] >> 6) != 2) {
                    return false;
                }
            }
            i += count;
        }
        return true;
    }
}