class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int n = releaseTimes.size();
        int max_dur = releaseTimes[0];
        int max_idx = 0;
        for (int i = 1; i < n; ++i) {
            if (releaseTimes[i] - releaseTimes[i-1] > max_dur) {
                max_dur = releaseTimes[i] - releaseTimes[i-1];
                max_idx = i;
            } else if (releaseTimes[i] - releaseTimes[i-1] == max_dur) {
                max_idx = keysPressed[i] > keysPressed[max_idx] ? i : max_idx;
            }
        }
        return keysPressed[max_idx];
    }
};