class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                h++;
            }
        }
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (left == 0 && right == 0) {
                    left = 1;
                    right = 1;
                } else if (left == 0) {
                    left = right;
                    right = 1;
                } else if (right == 0) {
                    right = left;
                    left = 1;
                } else {
                    left = 1;
                    right = 1;
                }
            } else {
                if (left == 0 && right == 0) {
                    left = 1;
                    right = 1;
                } else if (left == 0) {
                    left = right;
                    right = 0;
                } else if (right == 0) {
                    right = left;
                    left = 0;
                } else {
                    left = 0;
                    right = 0;
                }
            }
            res += left + right;
        }
        if (h == 0) {
            return 0;
        }
        if (res < h) {
            return -1;
        }
        return res;
    }
}