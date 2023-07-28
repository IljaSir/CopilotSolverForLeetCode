class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        int mod = 1e9 + 7;
        long long ans = 0;
        stack<int> st;
        st.push(0);
        for(int i = 0; i < n; i++){
            while(!st.empty() && strength[st.top()] >= strength[i]) st.pop();
            long long left = st.empty() ? i + 1 : i - st.top();
            st.push(i);
            st.push(i);
            while(!st.empty() && strength[st.top()] > strength[i]) st.pop();
            long long right = st.empty() ? n - i : st.top() - i;
            st.pop();
            ans += (long long)strength[i] * left * right % mod;
            ans %= mod;
        }
        return ans;
    }
};