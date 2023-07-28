class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> res, cur, next;
        for (int i = 0; i < arr.size(); ++i) {
            next = {arr[i]};
            for (int j : cur) next.insert(j | arr[i]);
            res.insert(next.begin(), next.end());
            cur = next;
        }
        return res.size();
    }
};