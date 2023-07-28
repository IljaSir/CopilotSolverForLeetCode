class Solution {
    public boolean validUtf8(int[] data) {
        
        int n = data.length;
        int i = 0;
        while (i < n) {
            int num = data[i];
            int count = 0;
            if (num >= 128) {
                while (num % 2 == 1) {
                    num /= 2;
                    count++;
                }
                if (count == 1 || count > 4) {
                    return false;
                }
                if (i + count > n) {
                    return false;
                }
                for (int j = i + 1; j < i + count; j++) {
                    if (data[j] < 128 || data[j] > 191) {
                        return false;
                    }
                }
                i += count;
            }
            i++;
        }
        return true;
    }
}