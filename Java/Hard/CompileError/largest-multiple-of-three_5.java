class Solution {
    public String largestMultipleOfThree(int[] digits) {
        
        int sum = 0;
        int[] count = new int[10];
        for (int d : digits) {
            sum += d;
            count[d]++;
        }
        if (sum % 3 == 1) {
            if (count[1] >= 1) {
                count[1]--;
            } else if (count[4] >= 1) {
                count[4]--;
            } else if (count[7] >= 1) {
                count[7]--;
            } else if (count[2] >= 2) {
                count[2] -= 2;
            } else if (count[5] >= 2) {
                count[5] -= 2;
            } else if (count[8] >= 2) {
                count[8] -= 2;
            } else if (count[2] >= 1 && count[5] >= 1 && count[8] >= 1) {
                count[2]--;
                count[5]--;
                count[8]--;
            } else {
                return "";
            }
        } else if (sum % 3 == 2) {
            if (count[2] >= 1) {
                count[2]--;
            } else if (count[5] >= 1) {
                count[5]--;
            } else if (count[8] >= 1) {
                count[8]--;
            } else if (count[1] >= 2) {
                count[1] -= 2;
            } else if (count[4] >= 2) {
                count[4] -= 2;
            } else if (count[7] >= 2) {
                count[7] -= 2;
            } else if (count[1] >= 1 && count[4] >= 1 && count[7] >= 1) {
                count[1]--;
                count[4]--;
                count[7]--;
            } else {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            return "0";
        }
        return sb
    }
}