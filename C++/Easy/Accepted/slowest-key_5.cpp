class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int n = releaseTimes.size();
        int mx = releaseTimes[0];
        char ch = keysPressed[0];
        for (int i = 1; i < n; ++i) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if (dur > mx) {
                mx = dur;
                ch = keysPressed[i];
            } else if (dur == mx) {
                ch = max(ch, keysPressed[i]);
            }
        }
        return ch;
    }
};