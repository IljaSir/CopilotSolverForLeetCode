class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return numSquarefulPerms(list);
    }
    
    private int numSquarefulPerms(List<Integer> list) {
        if (list.size() == 1) {
            return 1;
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (j != i) {
                    newList.add(list.get(j));
                }
            }
            if (list.size() == 2 || isSquare(num + list.get(i - 1))) {
                count += numSquarefulPerms(newList);
            }
        }
        return count;
    }
}