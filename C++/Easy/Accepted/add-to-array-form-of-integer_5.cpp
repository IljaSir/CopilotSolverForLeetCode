class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        int i = num.size() - 1;
        while (k > 0) {
            if (i < 0) {
                num.insert(num.begin(), 0);
                i = 0;
            }
            int sum = num[i] + k % 10;
            num[i] = sum % 10;
            k = k / 10 + sum / 10;
            --i;
        }
        return num;
    }
};