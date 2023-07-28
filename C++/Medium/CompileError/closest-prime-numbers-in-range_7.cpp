class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> ans;
        int diff = right - left;
        if (diff < 2) {
            ans.push_back(-1);
            ans.push_back(-1);
            return ans;
        }
        int n1 = -1;
        int n2 = -1;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (n1 == -1) {
                    n1 = i;
                } else {
                    if (n2 == -1) {
                        n2 = i;
                    } else {
                        if (i - n1 < n2 - n1) {
                            n2 = i;
                        }
                    }
                }
            }
        }
        ans.push_back(n1);
        ans.push_back(n2);
        return ans;
    }
};