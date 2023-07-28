class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int max = releaseTimes[0];
        int idx = 0;
        for (int i = 1; i < releaseTimes.size(); i++) {
            int t = releaseTimes[i] - releaseTimes[i-1];
            if (t > max) {
                max = t;
                idx = i;
            } else if (t == max) {
                if (keysPressed[i] > keysPressed[idx]) {
                    idx = i;
                }
            }
        }
        return keysPressed[idx];
    }
};