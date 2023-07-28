class Solution {
    public String removeOccurrences(String s, String part) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        char[] arr = s.toCharArray();
        char[] brr = part.toCharArray();
        while (i < s.length()) {
            if (arr[i] == brr[j]) {
                i++;
                j++;
            } else {
                arr[k] = arr[i];
                k++;
                i++;
                j = 0;
            }
            if (j == part.length()) {
                k -= j;
                j = 0;
            }
        }
        return new String(arr, 0, k);
    }
}