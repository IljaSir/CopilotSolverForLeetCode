class Solution {
    public String largestMultipleOfThree(int[] digits) {
        
        int[] count = new int[10];
        int sum = 0;
        for (int d : digits) {
            count[d]++;
            sum += d;
        }
        while (sum % 3 != 0) {
            for (int i = (sum % 3 == 1) ? 1 : 2; i < 10; i += 3) {
                if (count[i] > 0) {
                    count[i]--;
                    sum -= i;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i]-- > 0) {
                sb.append(i);
            }
        }
        return (sb.length() > 0 && sb.charAt(0) == '0') ? "0" : sb.toString();
    }
}