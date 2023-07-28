class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int i : arr) {
            Set<Integer> cur2 = new HashSet<>();
            for (int j : cur)
                cur2.add(i | j);
            cur2.add(i);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}