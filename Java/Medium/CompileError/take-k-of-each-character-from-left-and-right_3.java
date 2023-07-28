class Solution {
    public int takeCharacters(String s, int k) {
        
        int left = 0, riw int[3];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (count[i] < k) {
                return -1;
            }
        }
        int[] countLeft = new int[3];
        int[] countRight = new int[3];
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            countLeft[s.charAt(left) - 'a']++;
            countRight[s.charAt(right) - 'a']++;
            for (int i = 0; i < 3; i++) {
                if (countLeft[i] < k && countRight[i] < k) {
                    break;
                }
                if (i == 2) {
                    return left + 1 + s.length() - right;
                }
            }
            left++;
            right--;
        }
        return 0;
    }
}