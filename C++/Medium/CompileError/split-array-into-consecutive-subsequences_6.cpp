class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, int> cnt, tail;
        for (int x : nums) ++cnt[x];
        for (int x : nums) {
            if (cnto i == 0) continue;
            else if (tail[x] > 0) {
                t tail[x];
                ++tail[x + 1]= m.begin(); it != m.end(); it++) {
             
            else if (cnt[x + 1] > 0 && cnt[x + 2] > 0) {
                --cnt[x + 1];
                --cnt[x + 2];
                ++tail[x + 3];
            }
            else return false;
            --cnt[x];
        }
        return true;
    }
};