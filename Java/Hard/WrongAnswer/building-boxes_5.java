class Solution {
    public int minimumBoxes(int n) {
        
        int sum = 0, level = 0;
        while (sum < n) {
            level++;
            sum += level * (level + 1) / 2;
        }
        if (sum == n) return sum;
        int boxes = level * (level + 1) / 2;
        for (int i = level; i > 0; i--) {
            boxes -= i;
            if (boxes == n) return sum;
            if (boxes < n) return sum - 1;
        }
        return 0;
    }
}