class Solution {
    public int minimumBoxes(int n) {
        
        int i = 1;
        int sum = 0;
        while (sum < n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        i--;
        sum -= i * (i + 1) / 2;
        int j = 1;
        while (sum < n) {
            sum += j;
            j++;
        }
        return i * (i + 1) / 2 + j - 1;
    }
}