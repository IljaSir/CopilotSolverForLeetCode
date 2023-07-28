class Solution {
    public String reverseStr(String s, int k) {
        
        int i = 0;
        int j = k-1;
        int n = s.length();
        char[] arr = s.toCharArray();
        while (i < n) {
            if (j < n) {
                reverse(arr, i, j);
                i += 2*k;
                j += 2*k;
            } else {
                reverse(arr, i, n-1);
                break;
            }
        }
        return new String(arr);
    }
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}