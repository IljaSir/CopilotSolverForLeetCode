class Solution {
    public boolean isAdditiveNumber(String num) {
        
        int n = num.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isAdditive(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isAdditive(String num, int i, int j, int k) {
        if (num.charAt(i) == '0' && j - i > 1) {
            return false;
        }
        if (num.charAt(j) == '0' && k - j > 1) {
            return false;
        }
        long sum = 0;
        long first = Long.valueOf(num.substring(i, j));
        long second = Long.valueOf(num.substring(j, k));
        for (int l = k; l < num.length(); l++) {
            sum = first + second;
            String s = String.valueOf(sum);
            if (!num.startsWith(s, l)) {
                return false;
            }
            l += s.length() - 1;
            first = second;
            second = sum;
        }
        return true;
    }
}