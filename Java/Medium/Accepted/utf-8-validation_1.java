class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            int b = data[i];
            if ((b & 0b10000000) == 0) {
                i++;
            } else if ((b & 0b11100000) == 0b11000000) {
                if (i + 1 >= n) return false;
                if ((data[i + 1] & 0b11000000) != 0b10000000) return false;
                i += 2;
            } else if ((b & 0b11110000) == 0b11100000) {
                if (i + 2 >= n) return false;
                if ((data[i + 1] & 0b11000000) != 0b10000000) return false;
                if ((data[i + 2] & 0b11000000) != 0b10000000) return false;
                i += 3;
            } else if ((b & 0b11111000) == 0b11110000) {
                if (i + 3 >= n) return false;
                if ((data[i + 1] & 0b11000000) != 0b10000000) return false;
                if ((data[i + 2] & 0b11000000) != 0b10000000) return false;
                if ((data[i + 3] & 0b11000000) != 0b10000000) return false;
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }
}