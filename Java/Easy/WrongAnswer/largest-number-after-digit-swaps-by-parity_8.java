class Solution {
    public int largestInteger(int num) {
        
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] even = new int[n];
        int[] odd = new int[n];
        int ec = 0, oc = 0;
        for (int i = 0; i < n; i++) {
            int d = arr[i] - '0';
            if (d % 2 == 0) {
                even[ec++] = d;
            } else {
                odd[oc++] = d;
            }
        }
        int i = 0, j = 0;
        for (int k = n - 1; k >= 0; k--) {
            if (arr[k] % 2 == 0) {
                arr[k] = (char)(even[i++] + '0');
            } else {
                arr[k] = (char)(odd[j++] + '0');
            }
        }
        return Integer.parseInt(new String(arr));
    }
}