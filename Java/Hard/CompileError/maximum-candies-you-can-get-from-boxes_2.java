class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int n = words.length;
        int[] digits = new int[26];
        int[] carry = new int[10];
        Arrays.fill(digits, -1);
        Arrays.fill(carry, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int c = words[i].charAt(j) - 'A';
                if (digits[c] == -1 && j == words[i].length() - 1 && words[i].length() > 1) {
                    digits[c] = 0;
                }
            }
        }
        for (int i = 0; i < result.length(); i++) {
            int c = result.charAt(i) - 'A';
            if (digits[c] == -1 && i == result.length() - 1 && result.length() > 1) {
                digits[c] = 0;
            }
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int c = words[i].charAt(j) - 'A';
                nums[i] = nums[i] * 10 + digits[c];
            }
        }
        int res = 0;
        for (int i = 0; i < result.length(); i++) {
            int c = result.charAt(i) - 'A';
            res = res * 10 + digits[c];
        }
        return dfs(digits, carry, nums, res, 0, 0);
    }
    private boolean dfs(int[] digits, int[] carry, int[] nums, int res, int index, int cur) {
        if (index == digits.length) {
            return cur == res;
        }
        if (digits[index] != -1) {
            return dfs(digits, carry, nums, res, index + 1, cur);
        }
        for (int i = 0; i < 10; i++) {
            if (carry[i] == -1) {
                boolean valid = true;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] % 10 == i) {
                        valid = false;
                        break;
                    }
    }
}