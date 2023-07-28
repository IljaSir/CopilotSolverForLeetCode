class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> v;
        while(n) {
            v.push_back(n % 10);
            n /= 10;
        }
        sort(v.begin(), v.end());
        do {
            int res = 0;
            for(int i = 0; i < v.size(); ++i) {
                res = res * 10 + v[i];
            }
            if (res == 1 || res == 2 || res == 4 || res == 8 || res == 16 || res == 32 || res == 64 || res == 128 || res == 256 || res == 512 || res == 1024 || res == 2048 || res == 4096 || res == 8192 || res == 16384 || res == 32768 || res == 65536 || res == 131072 || res == 262144 || res == 524288 || res == 1048576 || res == 2097152 || res == 4194304 || res == 8388608 || res == 16777216 || res == 33554432 || res == 67108864 || res == 134217728 || res == 268435456 || res == 536870912 || res == 1073741824) {
                return true;
            }
        } while(next_permutation(v.begin(), v.end()));
        return false;
    }
};