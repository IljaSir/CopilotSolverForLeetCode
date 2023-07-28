class Solution {
    public int minimumBoxes(int n) {
        
        int i = 1;
        int sum = 0;
        while(sum < n) {
            sum += i;
            i++;
        }
        i--;
        int j = 1;
        while(sum > n) {
            sum -= i;
            i--;
            j++;
        }
        return (i * (i + 1) / 2) + j;
    }
}