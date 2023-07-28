class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        int[] ans = new int[seq.length()];
        int d = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(')
                d++;
            ans[i] = d % 2;
            if (seq.charAt(i) == ')')
                d--;
        }
        return ans;
    }
}