class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long perimeter = 0;
        long apples = 0;
        while (apples < neededApples) {
            perimeter += 2;
            apples += perimeter * 4;
            apples += (perimeter - 1) * 4;
            apples += (perimeter - 2) * 4;
        }
        return perimeter * 4;
    }
}