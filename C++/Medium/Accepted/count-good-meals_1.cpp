class Solution {
public:
    int countPairs(vector<int>& deliciousness) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int i = 0; i < deliciousness.size(); i++) {
            for (int j = 0; j < 22; j++) {
                int target = pow(2, j);
                if (m.count(target - deliciousness[i])) {
                    res = (res + m[target - deliciousness[i]]) % 1000000007;
                }
            }
            m[deliciousness[i]]++;
        }
        return res;
    }
};