class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long result = 0;
        long currentApples = 0;
        while (currentApples < neededApples) {
            result += 2;
            currentApples += 4 * result * (result + 1);
        }
        return result * 4;
    }
}