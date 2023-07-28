class Solution {
    public int largestInteger(int num) {
        
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] odd = new int[10];
        int[] even = new int[10];
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] - '0') % 2 == 0) {
                even[chars[i] - '0']++;
            } else {
                odd[chars[i] - '0']++;
            }
        }
        int i = 0;
        while (i < chars.length) {
            if ((chars[i] - '0') % 2 == 0) {
                for (int j = 9; j >= 0; j--) {
                    if (odd[j] > 0) {
                        odd[j]--;
                        chars[i] = (char) (j + '0');
                        break;
                    }
                }
            } else {
                for (int j = 9; j >= 0; j--) {
                    if (even[j] > 0) {
                        even[j]--;
                        chars[i] = (char) (j + '0');
                        break;
                    }
                }
            }
            i++;
        }
        return Integer.parseInt(new String(chars));
    }
}