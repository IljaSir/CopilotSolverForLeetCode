class Solution {
public:
    int getKth(int lo, int hi, int k) {
        
        vector<pair<int,int>> v;
        for (int i = lo; i <= hi; i++) {
            int count = 0;
            long long int temp = i;
            while (temp != 1) {
                if (temp % 2 == 0) {
                    temp /= 2;
                } else {
                    temp = 3 * temp + 1;
                }
                count++;
            }
            v.push_back({count, i});
        }
        sort(v.begin(), v.end());
        return v[k - 1].second;
    }
};