class Solution {
public:
    int compress(vector<char>& chars) {
        
        if (chars.size() <= 1) {
            return chars.size();
        }
        int slow = 0;
        int fast = 0;
        while (fast < chars.size()) {
            int count = 0;
            while (fast < chars.size() && chars[fast] == chars[slow]) {
                fast++;
                count++;
            }
            chars[slow] = chars[slow];
            slow++;
            if (count == 1) {
                continue;
            }
            string countStr = to_string(count);
            for (char c : countStr) {
                chars[slow] = c;
                slow++;
            }
        }
        return slow;
    }
};