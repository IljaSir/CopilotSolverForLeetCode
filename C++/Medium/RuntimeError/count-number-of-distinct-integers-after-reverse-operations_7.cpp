class Solution {
public:
    int countDistinctIntegers(vector<int>& nums) {
        
        unordered_set<int> s;
        for (int n : nums)
            s.insert(stoi(to_string(n) + string(to_string(n).rbegin(), to_string(n).rend())));
        return s.size();
    }
};