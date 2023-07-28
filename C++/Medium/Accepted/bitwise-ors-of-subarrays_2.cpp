class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> res, cur, pre;
        for (int i : arr) {
            cur = {i};
            for (int j : pre) cur.insert(i | j);
            res.insert(cur.begin(), cur.end());
            pre = cur;
        }
        return res.size();
    }
};