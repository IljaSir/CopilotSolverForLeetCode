class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        long long res = 0;
        sort(beans.begin(), beans.end());
        for (int i = 0; i < beans.size(); i++) {
            res += beans[i] - beans[0];
        }
        return res;
    }
};