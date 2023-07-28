class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        
        vector<int> ans;
        if (k == 0) {
            ans.resize(code.size(), 0);
            return ans;
        }
        int sum = 0;
        int n = code.size();
        int start = 0;
        int end = 0;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    sum -= code[start];
                    start = (start + 1) % n;
                    end = (end + 1) % n;
                    sum += code[end];
                }
                ans.push_back(sum);
            }
        } else {
            k = -k;
            start = n - 1;
            end = n - 1;
            for (int i = 0; i < k; i++) {
                sum += code[start];
                start = (start - 1 + n) % n;
            }
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    sum -= code[end];
                    start = (start - 1 + n) % n;
                    end = (end - 1 + n) % n;
                    sum += code[start];
                }
                ans.push_back(sum);
            }
        }
        return ans;
    }
};