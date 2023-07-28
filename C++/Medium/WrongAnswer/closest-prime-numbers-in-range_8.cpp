class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> ans;
        int min = INT_MAX;
        for(int i = left; i <= right; i++) {
            if(isPrime(i)) {
                if(i - left >= 2) {
                    if(i - left < min) {
                        min = i - left;
                        ans.clear();
                        ans.push_back(left);
                        ans.push_back(i);
                    }
                }
                left = i;
            }
        }
        if(ans.size() == 0) {
            ans.push_back(-1);
            ans.push_back(-1);
        }
        return ans;
    }
    bool isPrime(int n) {
        for(int i = 2; i <= sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
};