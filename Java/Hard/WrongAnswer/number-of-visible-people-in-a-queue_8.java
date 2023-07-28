class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[i] > heights[st.peek()]) {
                int j = st.pop();
                res[j] += 1;
                res[i] += res[j];
            }
            st.push(i);
        }
        return res;
    }
}