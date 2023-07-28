class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int maxTime = releaseTimes[0];
        char maxKey = keysPressed[0];
        for (int i = 1; i < releaseTimes.size(); i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > maxTime) {
                maxTime = time;
                maxKey = keysPressed[i];
            } else if (time == maxTime && keysPressed[i] > maxKey) {
                maxKey = keysPressed[i];
            }
        }
        return maxKey;
    }
};