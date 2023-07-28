class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> left, right, count;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i];
            if (left.find(x) == left.end()) left[x] = i;
            right[x] = i;
            count[x]++;
        }

        int ans = nums.size();
        int degree = *max_element(count.begin(), count.end(), [](const pair<int, int>& p1, const pair<int, int>& p2) {
            return p1.second < p2.second;
        }).second;
        for (auto& p : count) {
            int x = p.first;
            if (count[x] == degree) {
                ans = min(ans, right[x] - left[x] + 1);
            }
        }
        return ans;
    }
};