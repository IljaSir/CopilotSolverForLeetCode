class Solution {
    public String smallestNumber(String pattern) {
        
        int n = pattern.length();
        int[] num = new int[n+1];
        for (int i = 0; i <= n; i++) {
            num[i] = i;
        }
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && pattern.charAt(j) == 'D') {
                j++;
            }
            reverse(num, i, j);
            i = j + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int k : num) {
            sb.append(k);
        }
        return sb.toString();
    }
    
    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i++;
            j--;
        }
    }
}