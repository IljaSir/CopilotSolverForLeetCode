class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        int n = arr.length;
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> cur2 = new HashSet<>();
            cur2.add(arr[i]);
            for (int x: cur) cur2.add(x | arr[i]);
            ans.addAll(cur = cur2);
        }
        return ans.size();
    }
}