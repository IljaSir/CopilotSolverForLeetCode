class Solution {
public:
    vector<int> closestDivisors(int num) {
        
        int n1 = num + 1;
        int n2 = num + 2;
        vector<int> v1 = getDivisors(n1);
        vector<int> v2 = getDivisors(n2);
        int d1 = abs(v1[0] - v1[1]);
        int d2 = abs(v2[0] - v2[1]);
        if (d1 < d2) {
            return v1;
        } else {
            return v2;
        }
    }
    
    vector<int> getDivisors(int n) {
        int i = 1;
        int j = n;
        while (i <= j) {
            if (i * j == n) {
                break;
            } else if (i * j > n) {
                j--;
            } else {
                i++;
            }
        }
        return vector<int>{i, j};
    }
};