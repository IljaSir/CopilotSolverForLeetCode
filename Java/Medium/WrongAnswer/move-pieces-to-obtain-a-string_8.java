class Solution {
    public boolean canChange(String start, String target) {
        
        int n = start.length();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (start.charAt(i) == 'L') {
                count--;
            } else if (start.charAt(i) == 'R') {
                count++;
            }
            if (target.charAt(i) == 'L') {
                count++;
            } else if (target.charAt(i) == 'R') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
    public boolean canTransform(String start, String target) {
        if (!canChange(start, target)) {
            return false;
        }
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n) {
                return false;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L') {
                if (i < j) {
                    return false;
                }
            } else if (start.charAt(i) == 'R') {
                if (i > j) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}