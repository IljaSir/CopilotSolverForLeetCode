class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long apples = 0;
        long i = 0;
        while (apples < neededApples) {
            i++;
            apples += (i * 2 + 1) * (i * 2 + 1) * 2 + (i * 2) * (i * 2) * 2 + (i * 2 + 1) * (i * 2) * 4;
        }
        return i * 8;
    }
}