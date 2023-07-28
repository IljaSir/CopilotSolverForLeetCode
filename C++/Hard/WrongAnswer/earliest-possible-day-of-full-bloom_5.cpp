class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<int> bloom(n);
        for (int i = 0; i < n; i++) {
            bloom[i] = plantTime[i] + growTime[i];
        }
        sort(plantTime.begin(), plantTime.end());
        sort(bloom.begin(), bloom.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, plantTime[i] + bloom[n - i - 1]);
        }
        return ans;
    }
};