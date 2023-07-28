class Solution {
    public int[] constructRectangle(int area) {
        
        int l = (int)Math.sqrt(area);
        while (area % l != 0) {
            l--;
        }
        return new int[]{area / l, l};
    }
}