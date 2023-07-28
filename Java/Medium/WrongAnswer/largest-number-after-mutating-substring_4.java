class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] arr = num.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int digit = arr[i] - '0';
            if (digit < change[digit]) {
                while (i < n && arr[i] - '0' <= change[arr[i] - '0']) {
                    arr[i] = (char)(change[arr[i] - '0'] + '0');
                    i++;
                }
            } else {
                i++;
            }
        }
        return new String(arr);
    }
}