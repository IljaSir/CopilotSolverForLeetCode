class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        
        String str = String.valueOf(num);
        int len = str.length();
        if (len == 1) {
            return true;
        }
        int rem = len % 2;
        int mid = len / 2;
        int left = mid - 1;
        int right = mid + rem;
        while (left >= 0 && right < len) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
    }
}