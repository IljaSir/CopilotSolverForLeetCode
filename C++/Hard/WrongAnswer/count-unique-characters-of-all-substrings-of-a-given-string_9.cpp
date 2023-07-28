class Solution {
public:
    int uniqueLetterString(string s) {
        
        int result = 0;
        int size = s.size();
        vector<int> last(26, -1);
        vector<int> current(26, 0);
        for (int i = 0; i < size; ++i) {
            int index = s[i] - 'A';
            current[index] = i - last[index];
            last[index] = i;
        }
        for (int i = 0; i < 26; ++i) {
            last[i] = -1;
        }
        for (int i = size - 1; i >= 0; --i) {
            int index = s[i] - 'A';
            int next = last[index];
            last[index] = i;
            result += current[index] * (next - i);
        }
        return result;
    }
};