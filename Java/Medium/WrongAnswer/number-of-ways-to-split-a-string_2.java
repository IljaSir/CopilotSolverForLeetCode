class Solution {
    public int numWays(String s) {
        
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }
        if (ones % 3 != 0) return 0;
        if (ones == 0) {
            return (int)(((long)(s.length() - 1) * (s.length() - 2) / 2) % 1000000007);
        }
        int onePerPart = ones / 3;
        int firstPartEnd = 0;
        int secondPartEnd = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
            if (cnt == onePerPart) {
                firstPartEnd = i;
                break;
            }
        }
        cnt = 0;
        for (int i = firstPartEnd + 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
            if (cnt == onePerPart) {
                secondPartEnd = i;
                break;
            }
        }
        int firstPartLength = firstPartEnd + 1;
        int secondPartLength = secondPartEnd - firstPartEnd;
        int thirdPartLength = s.length() - secondPartEnd - 1;
        return (int)(((long)firstPartLength * secondPartLength * thirdPartLength) % 1000000007);
    }
}