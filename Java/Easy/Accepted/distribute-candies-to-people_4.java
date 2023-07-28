class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
        int[] result = new int[num_people];
        int i = 0;
        int candy = 1;
        while (candies > 0) {
            if (candies >= candy) {
                result[i] += candy;
            } else {
                result[i] += candies;
            }
            candies -= candy;
            candy++;
            i++;
            if (i == num_people) {
                i = 0;
            }
        }
        return result;
    }
}