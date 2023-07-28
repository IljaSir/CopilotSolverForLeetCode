class Solution {
    public int[] frequencySort(int[] nums) {
        
        int[] count = new int[201];
        for (int n : nums) {
            count[n + 100]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            list.add(i - 100);
        }
        Collections.sort(list, (a, b) -> {
            if (count[a + 100] != count[b + 100]) {
                return count[a + 100] - count[b + 100];
            }
            return b - a;
        });
        int[] res = new int[nums.length];
        int index = 0;
        for (int n : list) {
            for (int i = 0; i < count[n + 100]; i++) {
                res[index++] = n;
            }
        }
        return res;
    }
}