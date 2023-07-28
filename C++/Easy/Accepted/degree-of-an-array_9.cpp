class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        int maxFreq = 0;
        map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            m[nums[i]]++;
            maxFreq = max(maxFreq, m[nums[i]]);
        }
        map<int, int> firstPos;
        map<int, int> lastPos;
        for (int i = 0; i < nums.size(); i++) {
            if (m[nums[i]] == maxFreq) {
                if (firstPos.find(nums[i]) == firstPos.end()) {
                    firstPos[nums[i]] = i;
                }
                lastPos[nums[i]] = i;
            }
        }
        int minLength = nums.size();
        for (auto it = firstPos.begin(); it != firstPos.end(); it++) {
            minLength = min(minLength, lastPos[it->first] - it->second + 1);
        }
        return minLength;
    }
};