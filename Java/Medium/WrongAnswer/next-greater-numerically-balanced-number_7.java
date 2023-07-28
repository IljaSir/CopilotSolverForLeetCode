class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] digitCounts = new int[10];
        int m = n;
        while (m > 0) {
            digitCounts[m % 10]++;
            m /= 10;
        }
        int[] newDigitCounts = new int[10];
        int i = 1;
        while (true) {
            int d = i % 10;
            newDigitCounts[d]++;
            if (i >= 10) {
                newDigitCounts[i / 10] += newDigitCounts[9];
            }
            if (i >= 100) {
                newDigitCounts[i / 100] += newDigitCounts[9] * 2;
            }
            if (i >= 1000) {
                newDigitCounts[i / 1000] += newDigitCounts[9] * 3;
            }
            if (i >= 10000) {
                newDigitCounts[i / 10000] += newDigitCounts[9] * 4;
            }
            if (i >= 100000) {
                newDigitCounts[i / 100000] += newDigitCounts[9] * 5;
            }
            boolean found = true;
            for (int j = 0; j < 10; j++) {
                if (newDigitCounts[j] != digitCounts[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
            i++;
        }
    }
}