class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> ans(num_people, 0);
        int i = 0;
        int count = 1;
        while (candies > 0) {
            ans[i] += min(count, candies);
            candies -= count;
            count++;
            i++;
            i %= num_people;
        }
        return ans;
    }
};