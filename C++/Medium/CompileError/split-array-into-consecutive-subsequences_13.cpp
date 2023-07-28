class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, int> cnt, tail;
        for (int x : nums) ++cnt[x];
        for (int x : nums) {
            if (cnt[x] == 0) continue;
            else if (tail[x] > 0) {
                --tail[x];
                ++tail[x + 1];
            }
            else if (cnt[x + 1] > 0 && cnt[x + 2] > 0) {
                --cnto  + 1];
                --cnt[x + 2];
                ++tail[x + 3];
            }
            else return false;
            --cnt[x];
        }
        return true;
    }
};