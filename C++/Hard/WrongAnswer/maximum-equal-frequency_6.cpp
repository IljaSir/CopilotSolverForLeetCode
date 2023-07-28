class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        
        unordered_map<int, int> freq;
        unordered_map<int, int> count;
        int max_len = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int n = nums[i];
            int c = freq[n];
            if (c > 0) {
                if (count[c] == 1) {
                    count.erase(c);
                } else {
                    count[c]--;
                }
            }
            count[c + 1]++;
            freq[n]++;
            if (count.size() == 1) {
                auto it = count.begin();
                if (it->first == 1) {
                    max_len = i + 1;
                } else if (it->second == 1 && it->first == i + 1) {
                    max_len = i + 1;
                }
            } else if (count.size() == 2) {
                auto it = count.begin();
                auto jt = it;
                jt++;
                if (it->first == 1 && it->second == 1) {
                    max_len = i + 1;
                } else if (jt->first == it->first + 1 && jt->second == 1) {
                    max_len = i + 1;
                }
            }
        }
        return max_len;
    }
};