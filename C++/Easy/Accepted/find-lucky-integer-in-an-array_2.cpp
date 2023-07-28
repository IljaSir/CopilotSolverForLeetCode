class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        int max = -1;
        for (int i = 1; i <= 500; i++) {
            int cnt = 0;
            for (int j = 0; j < arr.size(); j++) {
                if (arr[j] == i) {
                    cnt++;
                }
            }
            if (cnt == i) {
                max = i;
            }
        }
        return max;
    }
};