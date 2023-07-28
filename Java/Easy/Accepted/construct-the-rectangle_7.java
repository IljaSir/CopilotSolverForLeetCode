class Solution {
    public int[] constructRectangle(int area) {
        
        int[] res = new int[2];
        int mid = (int) Math.sqrt(area);
        for(int i = mid; i > 0; i--) {
            if(area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        return res;
    }
}