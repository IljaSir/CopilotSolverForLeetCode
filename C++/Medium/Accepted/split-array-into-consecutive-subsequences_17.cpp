class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, int> freq, appendfreq;
        for (int x: nums) freq[x]++;
        for (int x: nums) {
            if (freq[x] == 0) continue;
            else if (appendfreq[x] > 0) {
                appendfreq[x]--;
                appendfreq[x+1]++;
            }
            else if (freq[x+1] > 0 && freq[x+2] > 0) {
                freq[x+1]--;
                freq[x+2]--;
                appendfreq[x+3]++;
            }
            else {
                return false;
            }
            freq[x]--;
        }
        return true;
    }
};