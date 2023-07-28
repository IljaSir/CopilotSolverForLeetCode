class Solution {
public:
    int threeSumMulti(vector<int>& arr, int target) {
        
        int N = arr.size();
        if (N < 3) return 0;
        long long mod = 1000000007;
        sort(arr.begin(), arr.end());
        long long ans = 0;
        for (int i = 0; i < N; ++i) {
            int t = target - arr[i];
            int l = i + 1, r = N - 1;
            while (l < r) {
                if (arr[l] + arr[r] < t) {
                    ++l;
                } else if (arr[l] + arr[r] > t) {
                    --r;
                } else {
                    if (arr[l] != arr[r]) {
                        int left = 1, right = 1;
                        while (l + 1 < r && arr[l] == arr[l + 1]) {
                            ++left;
                            ++l;
                        }
                        while (r - 1 > l && arr[r] == arr[r - 1]) {
                            ++right;
                            --r;
                        }
                        ans += (left * right) % mod;
                        ans %= mod;
                        ++l;
                        --r;
                    } else {
                        ans += (r - l + 1) * (r - l) / 2;
                        ans %= mod;
                        break;
                    }
                }
            }
        }
        return ans
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
};