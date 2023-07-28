class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        vector<int> ans;
        sort(arr.begin(), arr.end());
        map<int, vector<int>> m;
        for (auto x : arr) {
            int cnt = 0;
            int y = x;
            while (y) {
                cnt += (y & 1);
                y >>= 1;
            }
            m[cnt].push_back(x);
        }
        for (auto x : m) {
            for (auto y : x.second) {
                ans.push_back(y);
            }
        }
        return ans;
    }
};