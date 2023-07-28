class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        if (n1 == 0) {
            return 0;
        }
        int s1Count = 0, index = 0, s2Count = 0;
        int[] nextIndex = new int[s2.length() + 1];
        int[] repeatCount = new int[s2.length() + 1];
        while (true) {
            s1Count++;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        index = 0;
                        s2Count++;
                    }
                }
            }
            if (s1Count == n1) {
                return s2Count / n2;
            }
            if (nextIndex[index] != 0) {
                int s1CountDiff = s1Count - nextIndex[index];
                int s2CountDiff = s2Count - repeatCount[index];
                int patternCount = (n1 - s1Count) / s1CountDiff;
                s1Count += s1CountDiff * patternCount;
                s2Count += s2CountDiff * patternCount;
            } else {
                nextIndex[index] = s1Count;
                repeatCount[index] = s2Count;
            }
        }
    }
}