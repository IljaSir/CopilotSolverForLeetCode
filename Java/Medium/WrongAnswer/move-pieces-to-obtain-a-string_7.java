class Solution {
    public boolean canChange(String start, String target) {
        
        int n = start.length();
        int i = 0;
        while (i < n) {
            if (start.charAt(i) == target.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        if (i == n) {
            return true;
        }
        if (start.charAt(i) == '_') {
            if (i > 0 && target.charAt(i - 1) == 'R') {
                return false;
            }
            if (i < n - 1 && target.charAt(i + 1) == 'L') {
                return false;
            }
        } else if (target.charAt(i) == '_') {
            if (i > 0 && start.charAt(i - 1) == 'R') {
                return false;
            }
            if (i < n - 1 && start.charAt(i + 1) == 'L') {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean canTransform(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        if (!canChange(start, target)) {
            return false;
        }
        if (!canChange(target, start)) {
            return false;
        }
        return true;
    }
}