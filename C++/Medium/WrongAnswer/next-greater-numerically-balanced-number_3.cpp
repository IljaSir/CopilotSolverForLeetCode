class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int temp = n;
        vector<int> v;
        while (temp) {
            v.push_back(temp % 10);
            temp /= 10;
        }
        reverse(v.begin(), v.end());
        int i = v.size() - 1;
        while (i > 0) {
            if (v[i] > v[i - 1]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int j = v.size() - 1;
        while (j >= i) {
            if (v[j] > v[i - 1]) {
                break;
            }
            j--;
        }
        swap(v[j], v[i - 1]);
        sort(v.begin() + i, v.end());
        int res = 0;
        for (int i = 0; i < v.size(); i++) {
            res = res * 10 + v[i];
        }
        return res;
    }
};