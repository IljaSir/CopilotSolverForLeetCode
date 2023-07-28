class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = accumulate(arr.begin(), arr.end(), 0);
        if (sum % 3) return false;
        int part = sum / 3;
        int cnt = 0, cur = 0;
        for (int i = 0; i < arr.size(); ++i) {
            cur += arr[i];
            if (cur == part) {
                ++cnt;
                cur = 0;
            }
        }
        return cnt == 3;
    }
};