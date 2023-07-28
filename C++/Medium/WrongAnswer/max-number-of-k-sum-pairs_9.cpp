class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        
        unordered_map<int, int> count;
        for (auto n: nums) {
            ++count[n];
        }
        int res = 0;
        for (auto p: count) {
            if (p.first * 2 == k) {
                res += p.second / 2;
            } else if (p.first < k) {
                if (count.find(k - p.first) != count.end()) {
                    res += min(p.second, count[k - p.first]);
                }
            }
        }
        return res;
    }
};