class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> ans(num_people, 0);
        int i = 0;
        while (candies > 0) {
            ans[i] += min(candies, i + 1);
            candies -= i + 1;
            i = (i + 1) % num_people;
        }
        return ans;
    }
};