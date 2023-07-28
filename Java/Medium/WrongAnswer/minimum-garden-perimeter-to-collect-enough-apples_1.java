class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long n = 0;
        while (n * n * (n + 1) * (n + 1) < 2 * neededApples) {
            n++;
        }
        return n * 8;
    }
}