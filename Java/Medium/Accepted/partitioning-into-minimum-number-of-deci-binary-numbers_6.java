class Solution {
    public int minPartitions(String n) {
        
        int max = 0;
        for (char c : n.toCharArray()) {
            int d = c - '0';
            if (d > max) {
                max = d;
            }
        }
        return max;
    }
}