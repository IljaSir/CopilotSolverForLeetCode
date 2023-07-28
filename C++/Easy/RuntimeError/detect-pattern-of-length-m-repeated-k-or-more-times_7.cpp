class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        int i = 0;
        while (i < n) {
            int j = i + m;
            int count = 1;
            while (j < n) {
                bool ok = true;
                for (int t = 0; t < m; ++t) {
                    if (arr[i+t] != arr[j+t]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    ++count;
                    j += m;
                } else {
                    break;
                }
            }
            if (count >= k) {
                return true;
            }
            i += 1;
        }
        return false;
    }
};