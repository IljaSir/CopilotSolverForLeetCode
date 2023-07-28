class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long i = 0;
        while (true) {
            long apples = (i * 2 + 1) * (i * 2 + 1) * 3 / 2 + (i * 2 + 1) * 2;
            if (apples >= neededApples) {
                return (i * 2 + 1) * 4;
            }
            i++;
        }
    }
}