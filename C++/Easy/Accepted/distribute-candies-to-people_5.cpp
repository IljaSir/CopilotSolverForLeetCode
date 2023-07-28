class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> ans(num_people, 0);
        int cnt = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies - cnt < 0) {
                    ans[i] += candies;
                    candies = 0;
                    break;
                } else {
                    ans[i] += cnt;
                    candies -= cnt;
                    cnt++;
                }
            }
        }
        return ans;
    }
};