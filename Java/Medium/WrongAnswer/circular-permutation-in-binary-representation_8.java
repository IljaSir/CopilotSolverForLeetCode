class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> result = new ArrayList<>();
        result.add(start);
        int total = 1 << n;
        for (int i = 0; i < total - 1; i++) {
            int last = result.get(result.size() - 1);
            int next = last ^ (last & -last);
            result.add(next);
        }
        return result;
    }
}