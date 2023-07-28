class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        vector<int> count(501, 0);
        for (int i = 0; i < arr.size(); i++) {
            count[arr[i]]++;
        }
        int max = -1;
        for (int i = 1; i < 501; i++) {
            if (count[i] == i) {
                max = i;
            }
        }
        return max;
    }
};