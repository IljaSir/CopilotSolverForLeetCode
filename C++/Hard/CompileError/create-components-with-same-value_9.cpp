class Solution {
public:
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> p(n, -1);
        vector<int> sum(n, 0);
        for (auto& e : edges) {
            int a = e[0], b = e[1];
            int pa = find(p, a), pb = find(p, b);
            if (pa == pb) continue;
            p[pa] = pb;
            sum[pb] += sum[pa];
        }
        for (int i = 0; i < n; ++i) {
            if (p[i] == -1) {
                sum[i] = nums[i];
                continue;
            }
            sum[i] += nums[i];
        }
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            if (p[i] == -1) continue;
            int j = find(p, i);
            if (sum[j] != sum[i]) ret++;
        }
        return ret;
    }
    int find(vector<int>& p, int i) {
        return p[i] == -1 ? i : find(p, p[i]);
                nums[pa] = pb;
            } else {
                ++ans;
            }
        }
        return ans;
    }
};