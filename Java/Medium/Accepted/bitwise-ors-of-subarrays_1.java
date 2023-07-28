class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> ans = new HashSet(), cur = new HashSet(), cur2;
        for (int x: arr) {
            cur2 = new HashSet();
            cur2.add(x);
            for (int y: cur) cur2.add(x | y);
            ans.addAll(cur = cur2);
        }
        return ans.size();
    }
}