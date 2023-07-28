class Solution {
    public int twoEggDrop(int n) {
        
        int i = 1;
        int j = 1;
        while (i < n) {
            i += ++j;
        }
        return j;
    }
}