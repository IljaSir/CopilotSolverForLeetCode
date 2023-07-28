class Solution {
    public int[] minOperations(String boxes) {
        
        int[] res = new int[boxes.length()];
        int sum = 0;
        int ops = 0;
        for (int i = 0; i < boxes.length(); i++) {
            res[i] += ops;
            sum += boxes.charAt(i) - '0';
            ops += sum;
        }
        sum = 0;
        ops = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            res[i] += ops;
            sum += boxes.charAt(i) - '0';
            ops += sum;
        }
        return res;
    }
}