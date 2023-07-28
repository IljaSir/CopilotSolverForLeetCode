class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            int d = data[i];
            int count = 0;
            if ((d & 0x80) == 0) {
                count = 0;
            } else if ((d & 0xE0) == 0xC0) {
                count = 1;
            } else if ((d & 0xF0) == 0xE0) {
                count = 2;
            } else if ((d & 0xF8) == 0xF0) {
                count = 3;
            } else {
                return false;
            }
            i++;
            for (int j = 0; j < count; j++) {
                if (i >= n || (data[i] & 0xC0) != 0x80) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}