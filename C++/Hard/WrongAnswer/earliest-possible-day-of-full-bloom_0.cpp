class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        
        int n = plantTime.size();
        vector<int> bloomTime(n);
        for (int i = 0; i < n; ++i) {
            bloomTime[i] = plantTime[i] + growTime[i];
        }
        sort(bloomTime.begin(), bloomTime.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, plantTime[i]) + growTime[i];
            if (ans < bloomTime[i]) {
                ans = bloomTime[i];
            }
        }
        return ans;
    }
};