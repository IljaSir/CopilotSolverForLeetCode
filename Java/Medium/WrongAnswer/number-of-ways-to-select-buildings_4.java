class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }
        if (oneCount % 3 != 0) {
            return 0;
        }
        if (oneCount == 0) {
            return (long)(n - 1) * (n - 2) / 2 % 1000000007;
        }
        int k = oneCount / 3;
        int firstOneIndex = -1;
        int secondOneIndex = -1;
        int thirdOneIndex = -1;
        for (int i = 0, count = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
                if (count == 1) {
                    firstOneIndex = i;
                }
                if (count == k + 1) {
                    secondOneIndex = i;
                }
                if (count == 2 * k + 1) {
                    thirdOneIndex = i;
                }
            }
        }
        return (long)(secondOneIndex - firstOneIndex) * (thirdOneIndex - secondOneIndex) % 1000000007;
    }
}