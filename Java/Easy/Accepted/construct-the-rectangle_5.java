class Solution {
    public int[] constructRectangle(int area) {
        
        int[] result = new int[2];
        int l = (int) Math.sqrt(area);
        while (area % l != 0) {
            l--;
        }
        result[0] = area / l;
        result[1] = l;
        return result;
    }
}