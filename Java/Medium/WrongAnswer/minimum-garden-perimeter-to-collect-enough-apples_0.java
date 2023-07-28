class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long sum = 0;
        long i = 0;
        while (sum < neededApples) {
            i++;
            sum += 12 * i * (i + 1) * (2 * i + 1) / 6;
        }
        return i * 8;
    }
}