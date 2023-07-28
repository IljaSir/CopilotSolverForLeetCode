class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        unordered_map<int, int> m;
        for (int x : nums) m[x]++;
        for (auto& it : m) {
            if (it.second % 2 == 1) return false;
        }
        return true;
    }
};