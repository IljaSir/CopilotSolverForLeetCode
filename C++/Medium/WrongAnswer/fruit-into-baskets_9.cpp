class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int len = fruits.size();
        if (len == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        int last = fruits[0];
        int lastLast = fruits[0];
        for (int i = 1; i < len; i++) {
            if (fruits[i] == last) {
                count++;
            } else {
                if (fruits[i] == lastLast) {
                    count++;
                    last = lastLast;
                    lastLast = fruits[i];
                } else {
                    lastLast = last;
                    last = fruits[i];
                    count = 1;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
};