class Solution {
    public int strongPasswordChecker(String password) {
        
        int len = password.length();
        int ans = 0;
        int lower = 1;
        int upper = 1;
        int digit = 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                lower = 0;
            } else if (Character.isUpperCase(c)) {
                upper = 0;
            } else if (Character.isDigit(c)) {
                digit = 0;
            }
            if (i < len - 2 && password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                int j = i + 2;
                while (j < len && password.charAt(i) == password.charAt(j)) {
                    j++;
                }
                arr[i] = j - i;
                i = j - 1;
            }
        }
        int missing = lower + upper + digit;
        if (len < 6) {
            ans += missing + Math.max(0, 6 - (len + missing));
        } else {
            int over = Math.max(len - 20, 0);
            int left = 0;
            ans += over;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < len && over > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) {
                        continue;
                    }
                    arr[i] -= Math.min(over, k);
                    over -= k;
                }
            }
            for (int i = 0; i < len; i++) {
                if (arr[i] >= 3 && over > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over;
                    over -= need;
                }
                if (arr[i] >= 3) {
                    left += arr[i] / 3;
                }
            }
            ans += Math.max(missing, left);
        }
        return ans;
    }
}