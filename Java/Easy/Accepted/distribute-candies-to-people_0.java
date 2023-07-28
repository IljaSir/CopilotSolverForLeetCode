class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        
        int[] res = new int[num_people];
        int i = 0;
        while (candies > 0) {
            res[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
            i++;
        }
        return res;
    }
}