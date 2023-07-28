class Solution {
    public int minimumSum(int num) {
        
        int a = num / 100;
        int b = num % 100;
        int c = num / 10;
        int d = num % 10;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, a + b + c + d);
        min = Math.min(min, a + b + c * 10 + d);
        min = Math.min(min, a + b + c + d * 10);
        min = Math.min(min, a + b * 10 + c + d);
        min = Math.min(min, a + b * 10 + c * 10 + d);
        min = Math.min(min, a + b + c * 100 + d);
        min = Math.min(min, a + b * 100 + c + d);
        min = Math.min(min, a + b * 100 + c * 10 + d);
        min = Math.min(min, a + b * 10 + c * 100 + d);
        min = Math.min(min, a + b * 10 + c + d * 100);
        min = Math.min(min, a + b * 100 + c * 10 + d);
        min = Math.min(min, a + b * 100 + c + d * 10);
        min = Math.min(min, a * 10 + b + c + d);
        min = Math.min(min, a * 10 + b + c * 10 + d);
        min = Math.min(min, a * 10 + b + c + d * 10);
        min = Math.min(min, a * 10 + b * 10 + c + d);
        min = Math.min(min, a * 10 + b * 10 + c * 10 + d);
        min = Math.min(min, a * 10 + b + c * 100 + d);
        min = Math.min(min, a * 10 + b * 100 + c + d);
        min = Math.min(min, a * 10 + b * 100 + c * 10 + d);
        min = Math.min(min, a * 10 + b * 10 + c * 100 + d);
        min = Math.min(min, a * 10 + b * 10 + c + d * 100);
        min = Math.min
    }
}