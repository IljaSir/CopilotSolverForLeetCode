class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> left, right, count;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i];
            if (!left.count(x)) left[x] = i;
            right[x] = i;
            count[x]++;
        }

        int ans = nums.size();
        int degree = *max_element(count.begin(), count.end(), [](const auto& a, const auto& b) {
            return a.second < b.second;
        })->second;
        for (auto& [x, c]: count) {
            if (c == degree) {
                ans = min(ans, right[x] - left[x] + 1);
            }
        }
        return ans;
    }
};