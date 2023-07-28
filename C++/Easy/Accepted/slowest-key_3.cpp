class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int max = releaseTimes[0];
        char res = keysPressed[0];
        for (int i = 1; i < releaseTimes.size(); i++) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if (dur > max) {
                max = dur;
                res = keysPressed[i];
            } else if (dur == max) {
                if (keysPressed[i] > res) {
                    res = keysPressed[i];
                }
            }
        }
        return res;
    }
};