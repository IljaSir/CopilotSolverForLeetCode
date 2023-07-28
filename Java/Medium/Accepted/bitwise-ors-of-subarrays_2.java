class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> ans = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        cur.add(0);
        for (int x: arr) {
            Set<Integer> cur2 = new HashSet<Integer>();
            for (int y: cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}