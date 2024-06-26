class Solution {
    public String largestGoodInteger(String num) {
        
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] >= 3) {
                max = i;
            }
        }
        if (max == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count[max]; i++) {
            sb.append(max);
        }
        return sb.toString();
    }
}