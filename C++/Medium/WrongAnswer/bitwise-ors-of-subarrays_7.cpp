class Solution {
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        
        set<int> s;
        int n = arr.size();
        s.insert(arr[0]);
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            set<int> tmp;
            tmp.insert(arr[i]);
            for (int j : s) {
                tmp.insert(j | arr[i]);
            }
            s = tmp;
            prev = cur;
        }
        return s.size();
    }
};