class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[k];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()] && st.size() - 1 + n - i >= k) {
                st.pop();
            }
            if (st.size() < k) {
                st.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[st.pop()];
        }
        return res;
    }
}