class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        
        vector<pair<int, char>> A = {{a, 'a'}, {b, 'b'}, {c, 'c'}};
        string res;
        while (true) {
            sort(A.begin(), A.end());
            if (A[2].first == 0) break;
            if (A[2].first >= A[1].first + A[0].first) {
                res += A[2].second;
                res += A[2].second;
                A[2].first -= 2;
            } else {
                res += A[2].second;
                --A[2].first;
                if (A[1].first > 0) {
                    res += A[1].second;
                    --A[1].first;
                }
            }
        }
        return res;
    }
};