class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int num = data[i];
            if ((num & 0x80) == 0) {
                continue;
            }
            int count = 0;
            while ((num & 0x80) != 0) {
                count++;
                num = num << 1;
            }
            if (count == 1 || count > 4) {
                return false;
            }
            for (int j = 1; j < count; j++) {
                if (i + j >= n || (data[i + j] & 0xC0) != 0x80) {
                    return false;
                }
            }
            i += count - 1;
        }
        return true;
    }
}