class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> parent(n);
        iota(parent.begin(), parent.end(), 0);
        function<int(int)> find = [&](int x){
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        };
        function<void(int, int)> uni = [&](int x, int y){
            parent[find(x)] = find(y);
        };
        for (auto& e : edges){
            uni(e[0], e[1]);
        }
        vector<int> size(n);
        for (int i = 0; i < n; ++i){
            ++size[find(i)];
        }
        long long res = 0;
        for (auto& e : edges){
            int x = find(e[0]), y = find(e[1]);
            if (x != y){
                res += size[x] * size[y];
                uni(x, y);
                size[find(x)] = size[x] + size[y];
            }
        }
        return res;
    }
};