class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        map<int, int> cnt;
        for (auto& num : nums) {
            cnt[num]++;
        }
        map<int, int> tail;
        for (auto& num : nums) {
            if (cnt[num] == 0) {
                continue;
            }
            if (tail[num - 1] > 0) {
                cnt[num]--;
                tail[num - 1]--;
                tail[num]++;
            } else if (cnt[num + 1] > 0 && cnt[num + 2] > 0) {
                cnt[num]--;
                cnt[num + 1]--;
                cnt[num + 2]--;
                tail[num + 2]++;
            } else {
                return false;
            }
        }
        return true;
    }
};