class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> result(num_people, 0);
        int i = 0, j = 1;
        while (candies > 0) {
            result[i] += min(candies, j);
            candies -= j;
            j++;
            i = (i + 1) % num_people;
        }
        return result;
    }
};