class Solution {
    public int minimumBoxes(int n) {
        
        int level = 0, sum = 0;
        while (sum < n) {
            level++;
            sum += level * (level + 1) / 2;
        }
        while (sum > n) {
            sum -= level;
            level--;
        }
        return sum;
    }
}