class Solution {
public:
    string reverseWords(string s) {
        
        string result;
        int size = s.size();
        int i = 0;
        int j = size - 1;
        while (i < size && s[i] == ' ') {
            ++i;
        }
        while (j >= 0 && s[j] == ' ') {
            --j;
        }
        if (i > j) {
            return result;
        }
        result = s.substr(i, j - i + 1);
        int start = 0;
        int end = result.size() - 1;
        while (start < end) {
            swap(result[start], result[end]);
            ++start;
            --end;
        }
        int index = 0;
        int space = 0;
        for (int i = 0; i < result.size(); ++i) {
            if (result[i] == ' ') {
                if (space == 0) {
                    result[index++] = result[i];
                }
                ++space;
            } else {
                space = 0;
                result[index++] = result[i];
            }
        }
        result = result.substr(0, index);
        start = 0;
        end = result.size() - 1;
        while (start < end) {
            swap(result[start], result[end]);
            ++start;
            --end;
        }
        start = 0;
        end = 0;
        index = 0;
        while (end < result.size()) {
            while (end < result.size() && result[end] != ' ') {
                ++end;
            }
            int temp = end;
            --end;
            while (start < end) {
                swap(result[start], result[end]);
                ++start;
                --end;
            }
            start = temp + 1;
            end = temp + 1;
        }
        return result;
    }
};