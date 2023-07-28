class Solution {
    public int minimumBoxes(int n) {
        
        int i = 1;
        int sum = 0;
        while (sum + i <= n) {
            sum += i;
            i++;
        }
        int j = i - 1;
        while (sum + j > n) {
            j--;
        }
        return i * (i - 1) / 2 + j;
    }
}