class Solution {
    public int[] constructRectangle(int area) {
        
        int[] res = new int[2];
        int x = (int)Math.sqrt(area);
        while (area % x != 0) {
            x--;
        }
        res[0] = area / x;
        res[1] = x;
        return res;
    }
}