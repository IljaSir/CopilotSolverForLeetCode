class Solution {
    public int minimumBoxes(int n) {
        
        long sum = 0, i = 1;
        while (sum < n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        i--;
        sum -= i * (i + 1) / 2;
        while (sum + i <= n) {
            sum += i;
            i--;
        }
        return (int) (i * (i + 1) / 2 + n - sum);
    }
}