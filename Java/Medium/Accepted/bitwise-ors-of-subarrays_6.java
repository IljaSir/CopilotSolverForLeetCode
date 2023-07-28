class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> curr = new HashSet<>();
            curr.add(arr[i]);
            for (int j : prev) {
                curr.add(j | arr[i]);
            }
            result.addAll(curr);
            prev = curr;
        }
        return result.size();
    }
}