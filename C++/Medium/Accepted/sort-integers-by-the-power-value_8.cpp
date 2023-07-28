class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int, int>> v;
        for(int i = lo; i <= hi; i++){
            int t = i;
            int j = 0;
            while(t != 1){
                if(t % 2 == 0){
                    t /= 2;
                }else{
                    t = 3 * t + 1;
                }
                j++;
            }
            v.push_back(make_pair(i, j));
        }
        sort(v.begin(), v.end(), [](pair<int, int> &a, pair<int, int> &b){
            if(a.second == b.second){
                return a.first < b.first;
            }else{
                return a.second < b.second;
            }
        });
        return v[k - 1].first;
    }
};