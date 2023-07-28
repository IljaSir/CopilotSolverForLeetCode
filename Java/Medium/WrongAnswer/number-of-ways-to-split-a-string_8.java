class Solution {
    public int numWays(String s) {
        
        int mod = (int)1e9 + 7;
        int n = s.length();
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;
            }
        }
        if (oneCount % 3 != 0) {
            return 0;
        }
        if (oneCount == 0) {
            return (int)(((long)(n - 1) * (n - 2) / 2) % mod);
        }
        int oneCountPerPart = oneCount / 3;
        int count = 0;
        int i = 0;
        int firstPartEnd = -1;
        int secondPartEnd = -1;
        while (i < n) {
            if (s.charAt(i) == '1') {
                count++;
            }
            if (count == oneCountPerPart) {
                firstPartEnd = i;
                break;
            }
            i++;
        }
        count = 0;
        i++;
        while (i < n) {
            if (s.charAt(i) == '1') {
                count++;
            }
            if (count == oneCountPerPart) {
                secondPartEnd = i;
                break;
            }
            i++;
        }
        int firstPartLength = firstPartEnd + 1;
        int secondPartLength = secondPartEnd - firstPartEnd;
        int thirdPartLength = n - secondPartEnd;
        return (int)(((long)firstPartLength * secondPartLength) % mod);
    }
}