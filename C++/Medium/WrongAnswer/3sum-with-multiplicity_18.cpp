class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int result = 0;
        map<int, int> m;
        for (int i = 0; i < arr.size(); i++) {
            int t = target - arr[i];
            for (auto it = m.begin(); it != m.end(); it++) {
                if (m.find(t - it->first) != m.end()) {
                    result += it->second * m[t - it->first];
                    result %= 1000000007;
                }
            }
            m[arr[i]]++;
        }
        return result;
    }
};