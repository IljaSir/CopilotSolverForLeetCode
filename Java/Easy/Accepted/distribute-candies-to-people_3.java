class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
        int[] result = new int[num_people];
        int index = 0;
        int candy = 1;
        while (candies > 0) {
            result[index % num_people] += Math.min(candy, candies);
            candies -= candy;
            candy++;
            index++;
        }
        return result;
    }
}