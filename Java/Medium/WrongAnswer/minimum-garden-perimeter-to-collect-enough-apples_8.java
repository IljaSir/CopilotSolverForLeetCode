class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long n = 1;
        while (true) {
            long sum = 0;
            sum += 2 * n * (n + 1) * (2 * n + 1) / 3;
            sum += 2 * n * (n + 1) * (n + 2) * (n + 3) / 3;
            sum += n * (n + 1) * (2 * n + 1) / 3;
            sum += n * (n + 1) * (n + 2) * (n + 3) / 3;
            if (sum >= neededApples) {
                return 8 * n;
            }
            n++;
        }
    }
}