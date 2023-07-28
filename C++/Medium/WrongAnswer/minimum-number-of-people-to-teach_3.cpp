class Solution {
public:
    int minimumTeachings(int n, vector<vector<int>>& languages, vector<vector<int>>& friendships) {
        
        vector<vector<int>> lang;
        for(auto& v: languages) {
            sort(v.begin(), v.end());
            lang.push_back(v);
        }
        int m = languages.size();
        vector<int> cnt(n+1, 0);
        vector<vector<int>> lang_cnt(m+1, vector<int>(n+1, 0));
        for(auto& f: friendships) {
            int u = f[0], v = f[1];
            if(lang[u-1] == lang[v-1]) continue;
            for(auto l: lang[u-1]) {
                cnt[l]++;
                lang_cnt[u][l]++;
            }
            for(auto l: lang[v-1]) {
                cnt[l]++;
                lang_cnt[v][l]++;
            }
        }
        int ans = 0;
        for(auto& f: friendships) {
            int u = f[0], v = f[1];
            if(lang[u-1] == lang[v-1]) continue;
            bool ok = false;
            for(auto l: lang[u-1]) {
                if(lang_cnt[u][l] + lang_cnt[v][l] == cnt[l]) {
                    ok = true;
                    break;
                }
            }
            if(!ok) {
                for(auto l: lang[v-1]) {
                    if(lang_cnt[u][l] + lang_cnt[v][l] == cnt[l]) {
                        ok = true;
                        break;
                    }
                }
            }
            if(!ok) {
                ans++;
            }
        }
        return ans;
    }
};