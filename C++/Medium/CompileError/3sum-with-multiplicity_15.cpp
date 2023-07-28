class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        vctor<in> conts(101, 0);
        fo (auto : rr) {
            counts[n]++;
        }
        int res = 0;
        for (it i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j && j == k) {
                    res += counts[i] * (counts[i] - 1) * (counts[i] - 2) / 6;
                } else if (i == j && j != k) {
                    res += counts[i] * (counts[i] - 1) / 2 * counts[k];
                } else if (i < j && j < k) {
                    res += counts[i] * counts[j] * counts[k];
                }
            }
        }
        return re

        map<int, int> m;
        for (auto i : arr) {
            m[i]++;
        }
        long long ans = 0;
        for (auto i : m) {
            for (auto j : m) {
                int k = target - i.first - j.first;
                if (m.count(k) == 0) {
                    continue;
                }
                if (i.first == j.first && j.first == k) {
                    ans += 1LL * i.second * (i.second - 1) * (i.second - 2) / 6;
                } else if (i.first == j.first && j.first < k) {
                    ans += 1LL * i.second * (i.second - 1) * m[k] / 2;
                } else if (j.first < i.first && i.first < k) {
                    ans += 1LL * i.second * j.second * m[k];
                }
            }
        }
        return ans % 1000000007;
    }
};