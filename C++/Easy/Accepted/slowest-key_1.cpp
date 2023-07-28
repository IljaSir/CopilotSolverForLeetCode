class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        int max_time = releaseTimes[0];
        char max_key = keysPressed[0];
        for (int i = 1; i < releaseTimes.size(); i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max_time) {
                max_time = time;
                max_key = keysPressed[i];
            } else if (time == max_time && max_key < keysPressed[i]) {
                max_key = keysPressed[i];
            }
        }
        return max_key;
    }
};