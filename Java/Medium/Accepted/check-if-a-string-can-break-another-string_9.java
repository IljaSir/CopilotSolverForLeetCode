class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        int n = s1Arr.length;
        int i = 0;
        while (i < n && s1Arr[i] >= s2Arr[i]) {
            i++;
        }
        if (i == n) {
            return true;
        }
        i = 0;
        while (i < n && s2Arr[i] >= s1Arr[i]) {
            i++;
        }
        return i == n;
    }
}