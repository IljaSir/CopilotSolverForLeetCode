class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int max = 0;
        char maxChar;
        for (int i = 0; i < releaseTimes.size(); i++) {
            int duration;
            if (i == 0) {
                duration = releaseTimes[i];
            } else {
                duration = releaseTimes[i] - releaseTimes[i - 1];
            }
            if (duration > max) {
                max = duration;
                maxChar = keysPressed[i];
            } else if (duration == max) {
                maxChar = maxChar > keysPressed[i] ? maxChar : keysPressed[i];
            }
        }
        return maxChar;
    }
};