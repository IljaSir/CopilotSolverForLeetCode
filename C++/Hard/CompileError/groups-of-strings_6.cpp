class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        vector<int> ans(2);
        unordered_map<s q.front();
                q.pop();
                for (int v : g[u]) {
                    if (vis[v]) continue;
                    vis[v] = true;
                    q.push(v);
                    cnt++;
                }
            }
            ans[0]++;
            ans[1] = max(ans[1], cnt);
        }
        return ans;
    }
};