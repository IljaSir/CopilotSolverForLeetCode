class Solution {
    public boolean canTransform(String start, String end) {
        
        if (start.length() != end.length()) return false;
        int p1 = 0;
        int p2 = 0;
        while (p1 < start.length() || p2 < end.length()) {
            while (p1 < start.length() && start.charAt(p1) == 'X') {
                p1++;
            }
            while (p2 < end.length() && end.charAt(p2) == 'X') {
                p2++;
            }
            if (p1 == start.length() || p2 == end.length()) {
                break;
            }
            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            }
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;
        }
        return p1 == start.length() && p2

        if (start.length() != end.length()) return false;
        int i = 0, j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') i++;
            while (j < end.length() && end.charAt(j) == 'X') j++;
            if (i == start.length() || j == end.length()) break;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        while (i < start.length() && start.charAt(i) == 'X') i++;
        while (j < end.length() && end.charAt(j) == 'X') j++;
        return i == start.length() && j == end.length();
    }
}