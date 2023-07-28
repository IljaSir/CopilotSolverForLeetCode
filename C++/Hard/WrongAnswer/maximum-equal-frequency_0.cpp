class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        unordered_map<int, int> freq;
        unordered_map<int, int> count;
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = freq[num];
            if (f > 0) {
                count[f]--;
                if (count[f] == 0) {
                    count.erase(f);
                }
            }
            freq[num]++;
            f = freq[num];
            count[f]++;
            if (count.size() == 1) {
                if (count.begin()->first == 1 || count.begin()->second == 1) {
                    ans = i + 1;
                }
            } else if (count.size() == 2) {
                auto it = count.begin();
                auto it2 = it;
                it2++;
                if (it->first == 1 && it->second == 1) {
                    ans = i + 1;
                } else if (it2->first - it->first == 1 && it2->second == 1) {
                    ans = i + 1;
                }
            }
        }
        return ans;
    }
};