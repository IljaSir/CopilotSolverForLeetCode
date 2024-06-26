class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> result(num_people, 0);
        int i = 0;
        while (candies > 0) {
            result[i % num_people] += min(candies, i + 1);
            candies -= (i + 1);
            i++;
        }
        return result;
    }
};