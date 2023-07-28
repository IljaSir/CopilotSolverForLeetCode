class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {
        
        vector<int> ans;
        int i = num.size() - 1;
        while (i >= 0 || k > 0) {
            int sum  = 0;
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            ans.push_back(sum % 10);
            k += sum / 10;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};