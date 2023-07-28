class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        unordered_set<int> s(arr.begin(), arr.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j], l = 2;
                while (s.count(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                ans = max(ans, l);
            }
        }
        return ans > 2 ? ans : 0;
    }
};