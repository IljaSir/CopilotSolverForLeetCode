class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        
        int p1 = 0, p2 = 0;
        int[] count = new int[s2.length()];
        int[] next = new int[s2.length()];
        while (p1 < s1.length() * n1) {
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) == s2.charAt(p2)) {
                    p2++;
                    if (p2 == s2.length()) {
                        p2 = 0;
                        count[p1 % s2.length()]++;
                    }
                }
            }
            p1++;
            next[p1 % s2.length()] = p2;
            if (p1 % s2.length() == p2) {
                int cycle = (s1.length() * n1 - p1) / (p1 - next[p1 % s2.length()]);
                p1 += cycle * (p1 - next[p1 % s2.length()]);
                p2 += cycle * (p2 - count[p1 % s2.length()]);
            }
        }
        return count[(s1.length() * n1 - 1) % s2.length()] / n2;
    }
}