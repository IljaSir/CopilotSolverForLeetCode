class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        
        int n = cards.size();
        if (n == 1) return -1;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[cards[i]]++;
        }
        int res = INT_MAX;
        for (auto& p : m) {
            if (p.second >= 2) {
                int start = 0;
                int end = n - 1;
                int count = 0;
                while (start <= end) {
                    if (cards[start] == p.first) {
                        count++;
                        start++;
                    } else if (cards[end] == p.first) {
                        count++;
                        end--;
                    } else {
                        count += 2;
                        start++;
                        end--;
                    }
                }
                res = min(res, count);
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};