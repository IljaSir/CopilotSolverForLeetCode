class Solution {
    public boolean validUtf8(int[] data) {
        
        int i = 0;
        while (i < data.length) {
            int n = 0;
            int b = data[i];
            if ((b & 0x80) == 0) {
                i++;
            } else if ((b & 0xe0) == 0xc0) {
                n = 1;
                i++;
            } else if ((b & 0xf0) == 0xe0) {
                n = 2;
                i++;
            } else if ((b & 0xf8) == 0xf0) {
                n = 3;
                i++;
            } else {
                return false;
            }
            while (n > 0) {
                if (i >= data.length) {
                    return false;
                }
                b = data[i];
                if ((b & 0xc0) != 0x80) {
                    return false;
                }
                n--;
                i++;
            }
        }
        return true;
    }
}