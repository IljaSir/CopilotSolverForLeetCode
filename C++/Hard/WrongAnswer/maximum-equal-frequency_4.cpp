class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        unordered_map<int, int> freq;
        unordered_map<int, int> count;
        int maxLen = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            int f = freq[num];
            freq[num]++;
            if (f > 0) {
                count[f]--;
                if (count[f] == 0) {
                    count.erase(f);
                }
            }
            count[f + 1]++;
            if (count.size() == 1) {
                int k = count.begin()->first;
                if (k == 1 || k * count[k] == i + 1) {
                    maxLen = i + 1;
                }
            }
            if (count.size() == 2) {
                auto it = count.begin();
                int k1 = it->first;
                it++;
                int k2 = it->first;
                if (k1 == 1 && it->second == 1) {
                    maxLen = i + 1;
                }
                if (k2 == k1 + 1 && count[k1] == 1) {
                    maxLen = i + 1;
                }
            }
        }
        return maxLen;
    }
};