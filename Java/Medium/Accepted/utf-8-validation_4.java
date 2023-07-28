class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            int d = data[i];
            if (d < 0b10000000) {
                i++;
            } else if (d < 0b11000000) {
                return false;
            } else if (d < 0b11100000) {
                if (i + 1 >= n) {
                    return false;
                }
                int d1 = data[i + 1];
                if (d1 < 0b10000000 || d1 >= 0b11000000) {
                    return false;
                }
                i += 2;
            } else if (d < 0b11110000) {
                if (i + 2 >= n) {
                    return false;
                }
                int d1 = data[i + 1];
                int d2 = data[i + 2];
                if (d1 < 0b10000000 || d1 >= 0b11000000 || d2 < 0b10000000 || d2 >= 0b11000000) {
                    return false;
                }
                i += 3;
            } else if (d < 0b11111000) {
                if (i + 3 >= n) {
                    return false;
                }
                int d1 = data[i + 1];
                int d2 = data[i + 2];
                int d3 = data[i + 3];
                if (d1 < 0b10000000 || d1 >= 0b11000000 || d2 < 0b10000000 || d2 >= 0b11000000 || d3 < 0b10000000 || d3 >= 0b11000000) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }
}