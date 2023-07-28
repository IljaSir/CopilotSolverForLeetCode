class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        if (n <= 1) {
            return n;
        }
        vector<int> next(n);
        vector<int> stack(n);
        int top = -1;
        auto cmp = [&](int i, int j) {
            if (arr[i] != arr[j]) {
                return arr[i] < arr[j];
            }
            return i < j;
        };
        for (int i = n - 1; i >= 0; --i) {
            while (top > 0 && cmp(stack[top], i)) {
                --top;
            }
            next[i] = top > 0 ? stack[top] : -1;
            stack[++top] = i;
        }
        vector<bool> odd(n);
        vector<bool> even(n);
        odd[n - 1] = even[n - 1] = true;
        for (int i = n - 2; i >= 0; --i) {
            if (next[i] != -1) {
                odd[i] = even[next[i]];
                even[i] = odd[next[i]];
            }
        }
        return accumulate(odd.begin(), odd.end(), 0);
    }
};