class Solution {
    public int minimumBoxes(int n) {
        
        int i = 1;
        int sum = 0;
        while (sum + i * (i + 1) / 2 <= n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        i--;
        int j = 1;
        while (sum + j <= n) {
            sum += j;
            j++;
        }
        return i * i + j - 1;
    }
}