class Solution {
public:
    int countVowelPermutation(int n) {
        
        // aeiou
        // 1, 2, 3, 4, 5
        // a -> e
        // e -> a, i
        // i -> a, e, o, u
        // o -> i, u
        // u -> a
        // a -> e, i, u
        // e -> i, o
        // i -> o
        // o -> i
        // u -> o, i
        // 1, 2, 3, 4, 5
        // 1 -> 2, 3, 5
        // 2 -> 1, 3
        // 3 -> 1, 2, 4, 5
        // 4 -> 3, 5
        // 5 -> 1, 3
        // a -> e, i, u
        // e -> a, i
        // i -> a, e, o, u
        // o -> i, u
        // u -> a
        // a -> e, i, u
        // e -> i, o
        // i -> o
        // o -> i
        // u -> o, i
        // 1, 2, 3, 4, 5
        // 1 -> 2, 3, 5
        // 2 -> 1, 3
        // 3 -> 1, 2, 4, 5
        // 4 -> 3, 5
        // 5 -> 1, 3
        // a -> e, i, u
        // e -> a, i
        // i -> a, e, o, u
        // o -> i, u
        // u -> a
        // a -> e, i, u
        // e -> i, o
        // i -> o
        // o -> i
        // u -> o, i
        // 1, 2, 3, 4, 5
        // 1 -> 2, 3, 5
        // 2 -> 1, 3
        // 3 -> 1, 2, 4, 5
        // 4 -> 3, 5
        //ng na = (e + i + u) % M;
            long long ne = (a + i) % M;
            long long ni = (e + o) % M;
            long long no = i;
            long long nu = (i + o) % M;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return (a + e + i + o + u) % M;
    }
};