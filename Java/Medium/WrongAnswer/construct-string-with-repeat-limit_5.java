class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > repeatLimit) {
                return "";
            }
        }
        char[] result = new char[n];
        int i = 0;
        int j = 0;
        while (i < n) {
            int k = i;
            while (k < n && arr[k] == arr[i]) {
                k++;
            }
            int len = Math.min(k - i, repeatLimit);
            for (int l = 0; l < len; l++) {
                result[j++] = arr[i];
            }
            i = k;
        }
        return new String(result);
    }
}