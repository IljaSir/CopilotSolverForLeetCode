class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        
        int l = 0, r = maxSum;
        while(l < r) {
            int mid = (l + r + 1) / 2;
            long long sum = mid;
            int left = index, right = index;
            while(left > 0 || right < n - 1) {
                if(left == 0)
                    sum += mid - 1, right++;
                else if(right == n - 1)
                    sum += mid - 1, left--;
                else if(mid - 1 > mid - (index - left + 1))
                    sum += mid - 1, right++;
                else
                    sum += mid - 1, left--;
            }
            if(sum > maxSum)
                r = mid - 1;
            else
                l = mid;
        }
        return l;
    }
};