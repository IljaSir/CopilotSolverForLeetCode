class Solution {
    public boolean canTransform(String start, String end) {
        
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i == n || j == n) {
                break;
            }
            if (start.charAt(i) != end.charAt(j) || (start.charAt(i) == 'L' && i < j) || (start.charAt(i) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}