class Solution {
    public int minimumBoxes(int n) {
        
        int level = 0;
        int sum = 0;
        while(sum + (level + 1) * (level + 2) / 2 <= n) {
            sum += (level + 1) * (level + 2) / 2;
            level++;
        }
        int i = 1;
        while(sum + i * (i + 1) / 2 <= n) {
            sum += i * (i + 1) / 2;
            i++;
        }
        return level * level + i - 1;
    }
}