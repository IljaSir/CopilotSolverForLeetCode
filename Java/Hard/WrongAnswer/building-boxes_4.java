class Solution {
    public int minimumBoxes(int n) {
        
        int sum = 0;
        int level = 1;
        while (sum < n) {
            sum += level * (level + 1) / 2;
            level++;
        }
        level--;
        sum -= level * (level + 1) / 2;
        int boxes = level * (level + 1) / 2;
        while (sum < n) {
            sum += level;
            boxes++;
            level--;
        }
        return boxes;
    }
}