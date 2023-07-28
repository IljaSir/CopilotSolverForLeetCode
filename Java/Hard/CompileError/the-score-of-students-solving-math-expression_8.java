class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[] nums = new int[n / 2 + 1];
        char[] ops = new char[n / 2];
        int num = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                nums[idx] = num;
                ops[idx] = c;
                num = 0;
                idx++;
            }
        }
        nums[idx] = num;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ops[i - 1] == '+') {
                ans += nums[i];
            } else {
                ans *= nums[i];
            }
        }
        int res = 0;t;
    }
}