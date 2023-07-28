class Solution {
public:
    char slowestKey(vector<int>& releaseTimes, string keysPressed) {
        
        char c = keysPressed[0];
        int max = releaseTimes[0];
        for (int i = 1; i < releaseTimes.size(); i++) {
            int dur = releaseTimes[i] - releaseTimes[i - 1];
            if (dur > max || (dur == max && keysPressed[i] > c)) {
                c = keysPressed[i];
                max = dur;
            }
        }
        return c;
    }
};