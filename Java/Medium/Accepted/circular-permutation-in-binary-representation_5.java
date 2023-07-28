class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> result = new ArrayList<>();
        result.add(start);
        int mask = 1;
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) ^ mask);
            }
            mask <<= 1;
        }
        return result;
    }
}