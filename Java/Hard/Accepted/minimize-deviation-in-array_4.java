class Solution {
    public int minimumDeviation(int[] nums) {
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n % 2 == 0 ? n : n * 2);
        }
        int res = set.last() - set.first();
        while (set.last() % 2 == 0) {
            set.add(set.last() / 2);
            set.remove(set.last());
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }
}