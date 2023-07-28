class Solution {
    public int getMinSwaps(String num, int k) {
        
        String target = num;
        for (int i = 0; i < k; i++) {
            target = nextPermutation(target);
        }
        int swaps = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != target.charAt(i)) {
                for (int j = i + 1; j < num.length(); j++) {
                    if (num.charAt(j) == target.charAt(i)) {
                        for (int k1 = j; k1 > i; k1--) {
                            num = swap(num, k1, k1 - 1);
                            swaps++;
                        }
                        break;
                    }
                }
            }
        }
        return swaps;
    }
    private String swap(String num, int i, int j) {
        char[] chars = num.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
    private String nextPermutation(String num) {
        char[] chars = num.toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i + 1] <= chars[i]) {
            i--;
        }
        if (i >= 0) {
            int j = chars.length - 1;
            while (j >= 0 && chars[j] <= chars[i]) {
                j--;
            }
            swap(chars, i, j);
        }
        reverse(chars, i + 1);
        return new String(chars);
    }
    private void reverse(char[] chars, int start) {
        int i = start, j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }
}