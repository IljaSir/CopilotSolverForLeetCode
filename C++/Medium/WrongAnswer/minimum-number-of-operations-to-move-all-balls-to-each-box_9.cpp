class Solution {
public:
    vector<int> minOperations(string boxes) {
        
        vector<int> ret(boxes.size(), 0);
        int count = 0, index = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes[i] == '1') {
                ret[0] += index;
                count++;
            }
            index++;
        }
        for (int i = 1; i < boxes.size(); i++) {
            if (boxes[i - 1] == '1') {
                count--;
            }
            ret[i] = ret[i - 1] + count - (boxes.size() - i - count);
        }
        return ret;
    }
};