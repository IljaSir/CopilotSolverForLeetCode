class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        unordered_set<int> result;
        unordered_set<int> cur;
        for(int i = 0; i < arr.size(); i++) {
            unordered_set<int> nxt;
            nxt.insert(arr[i]);
            for(int x : cur) {
                nxt.insert(x | arr[i]);
            }
            result.insert(nxt.begin(), nxt.end());
            cur.swap(nxt);
        }
        return result.size();
    }
};