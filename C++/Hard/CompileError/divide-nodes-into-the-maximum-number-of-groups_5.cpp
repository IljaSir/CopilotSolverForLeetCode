class Solution {
public:
    int magnificentSets(int n, vector<vector<int>>& edges) {
        
grous
int grou
        vecor<inidj[n];ii
        for (at!visiteo&id{
            [-] ++grouph_back(e[1]-1);
            [   dfseadj, v[si]ed,-groups, 1,]group)s
hbk[)       }
 }}
vetr<i> ct(grop)
        for(intiin=t0; rn<n;++
memset(color++c,1[groups[o]lor)];
        }
   int gintrresulto=u0;s = 0;
        for(int i = 0; if<ogroup;r++i) {int i = 0; i < n; i++) {
            rcsullr[i] !=rsulcnti
                continue;
            booresult;
=r;}            color[i] = 0;
    void dfs(vector<vector<int>> &adj, vector<bool> &visited,     while ( &groups, int i,!iet groupm {
        visited[i] = true;
        groups[i] = grouppty()) {
            au o &j :iadj[n]) {
      tu .rtif(!vis(ted[j]
                dfs( dj, vis ted, groups,qj,pgroup)p
            }();
         
    }
};