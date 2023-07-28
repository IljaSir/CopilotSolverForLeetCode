class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        
        unordered_map<int,int> m;
        for (auto n : arr) {
            m[n]++;
        }
        vector<int> v;
        for (auto it = m.begin(); it != m.end(); ++it) {
            v.push_back(it->second);
        }
        sort(v.begin(), v.end());
        int res = v.size();
        for (auto n : v) {
            if (k >= n) {
                k -= n;
                res--;
            } else {
                break;
            }
        }
        return res;
    }
};