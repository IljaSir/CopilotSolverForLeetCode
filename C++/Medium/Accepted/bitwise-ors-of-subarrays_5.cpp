class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        set<int> ans;
        set<int> cur;
        for (auto x: arr) {
            set<int> cur2;
            cur2.insert(x);
            for (auto y: cur) {
                cur2.insert(x | y);
            }
            cur = cur2;
            for (auto y: cur) {
                ans.insert(y);
            }
        }
        return ans.size();
    }
};