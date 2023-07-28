class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> cur2 = new HashSet<>();
            cur2.add(arr[i]);
            for (int y : cur) cur2.add(arr[i] | y);
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}