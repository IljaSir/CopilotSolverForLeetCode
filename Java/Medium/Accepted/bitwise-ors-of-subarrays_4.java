class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int x: arr) {
            Set<Integer> cur2 = new HashSet<>();
            for (int y: cur)
                cur2.add(x | y);
            cur2.add(x);
            ans.addAll(cur = cur2);
        }

        return ans.size();
    }
}