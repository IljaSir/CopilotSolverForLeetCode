class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, vector<int>> m;
        for(int i = 0; i < nums.size(); ++i) {
            m[nums[i]].push_back(i);
        }
        int max_degree = 0;
        int min_len = 0;
        for(auto& p : m) {
            int degree = p.second.size();
            if(degree > max_degree) {
                max_degree = degree;
                min_len = p.second.back() - p.second.front() + 1;
            } else if(degree == max_degree) {
                min_len = min(min_len, p.second.back() - p.second.front() + 1);
            }
        }
        return min_len;
    }
};