class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int max = releaseTimes[0];
        int len = releaseTimes.size();
        char res = keysPressed[0];
        for (int i = 1; i < len; i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > max) {
                max = time;
                res = keysPressed[i];
            } else if (time == max) {
                if (keysPressed[i] > res) {
                    res = keysPressed[i];
                }
            }
        }
        return res;
    }
};