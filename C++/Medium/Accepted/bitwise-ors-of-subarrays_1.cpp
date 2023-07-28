class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> res, cur, cur2;
        for (int i : arr) {
            cur2 = {i};
            for (int j : cur) cur2.insert(i | j);
            cur = cur2;
            res.insert(cur.begin(), cur.end());
        }
        return res.size();
    }
};