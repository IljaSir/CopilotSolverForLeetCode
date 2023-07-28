class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<int> bloom(n);
        vector<int> grow(n);
        for (int i = 0; i < n; i++) {
            bloom[i] = plantTime[i] + growTime[i];
            grow[i] = growTime[i];
        }
        sort(bloom.begin(), bloom.end());
        sort(grow.begin(), grow.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, bloom[i] + grow[n - 1 - i]);
        }
        return ans;
    }
};