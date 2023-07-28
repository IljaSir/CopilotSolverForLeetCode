class Solution {
    public String minInteger(String num, int k) {
        
        int n = num.length();
        char[] chars = num.toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[chars[i] - '0']++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (count[j] == 0) {
                    continue;
                }
                int index = -1;
                for (int l = i; l < n; l++) {
                    if (chars[l] - '0' == j) {
                        index = l;
                        break;
                    }
                }
                int steps = index - i;
                if (steps <= k) {
                    k -= steps;
                    count[j]--;
                    while (index > i) {
                        chars[index] = chars[index - 1];
                        index--;
                    }
                    chars[i] = (char) (j + '0');
                    break;
                }
            }
        }
        return new String(chars);
    }
}