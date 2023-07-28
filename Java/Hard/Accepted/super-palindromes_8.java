class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        int count = 0;
        long start = Long.parseLong(left);
        long end = Long.parseLong(right);
        long max = (long) Math.sqrt(end);
        for (long i = 1; i <= max; i++) {
            String s = String.valueOf(i);
            String s2 = new StringBuilder(s).reverse().toString();
            long num = Long.parseLong(s + s2);
            long square = num * num;
            if (square > end) {
                break;
            }
            if (square >= start && isPalindrome(String.valueOf(square))) {
                count++;
            }
        }
        for (long i = 1; i <= max; i++) {
            String s = String.valueOf(i);
            String s2 = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            long num = Long.parseLong(s + s2);
            long square = num * num;
            if (square > end) {
                break;
            }
            if (square >= start && isPalindrome(String.valueOf(square))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}