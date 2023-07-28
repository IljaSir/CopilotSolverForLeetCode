class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        
        vector<int> res(num_people);
        int n = 1;
        while (candies > 0) {
            res[(n-1)%num_people] += min(n, candies);
            candies -= n;
            n++;
        }
        return res;
    }
};