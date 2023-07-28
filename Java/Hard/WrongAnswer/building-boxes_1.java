class Solution {
    public int minimumBoxes(int n) {
        
        int i = 1;
        int sum = 0;
        while (sum + i * (i + 1) / 2 <= n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        int j = i - 1;
        while (sum < n) {
            sum += j;
            j--;
        }
        return sum;
    }
}