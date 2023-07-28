class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> res, cur, pre;
        for (int a: arr) {
            cur = {a};
            for (int b: pre) cur.insert(a | b);
            res.insert(cur.begin(), cur.end());
            pre = cur;
        }
        return res.size();
    }
};