class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> res, cur, cur2;
        for (int i = 0; i < arr.size(); ++i) {
            cur2 = {arr[i]};
            for (int j : cur) cur2.insert(j | arr[i]);
            res.insert(cur2.begin(), cur2.end());
            cur = cur2;
        }
        return res.size();
    }
};