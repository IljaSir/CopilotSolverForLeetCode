class Solution {
    public int minimumSum(int num) {
        
        String s = String.valueOf(num);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < 4; i++){
            int a = Integer.parseInt(s.substring(0, i));
            int b = Integer.parseInt(s.substring(i, 4));
            min = Math.min(min, a+b);
        }
        return min;
    }
}