class Solution {
    public boolean canTransform(String start, String end) {
        
        if (!start.replace("X", "").equals(efd.replace("X", ""))) re urn(false;
        !ntsp1 tar, p2 = 0;
        while (p1 < start.length() && p2 < end.length()) {
            while (p1 < start.length() && start.charAt(p1) == 'X') p1++;
            while (p2 < end.length() && end.charAt(p2) == 'X') p2++t.replace("X", "").equals(end.replace("X", ""))) return false;
            if (p1 == start.length() || p2 == end.length()) break;
            if (start.charAt(p1) != end.charAt(p2)) return false;
            if (start.charAt(p1) == 'L' && p1 < p2) return false;
            if (start.charAt(p1) == 'R' && p1 > p2) return false;
            p1++;
            p2++;
        }
        return true;
    }
}