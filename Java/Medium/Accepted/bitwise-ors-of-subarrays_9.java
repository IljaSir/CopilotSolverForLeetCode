class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> result = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            next.add(arr[i]);
            for (int j : prev) {
                next.add(j | arr[i]);
            }
            result.addAll(next);
            prev = next;
            next = new HashSet<>();
        }
        return result.size();
    }
}