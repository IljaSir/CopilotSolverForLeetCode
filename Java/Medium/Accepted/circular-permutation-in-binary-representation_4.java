class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        
        List<Integer> res = new ArrayList<>();
        int size = 1 << n;
        for (int i = 0; i < size; i++) {
            res.add(start ^ i ^ i >> 1);
        }
        return res;
    }
}