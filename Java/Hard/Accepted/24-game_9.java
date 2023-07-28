class Solution {
    public boolean judgePoint24(int[] cards) {
        
        if (cards == null || cards.length == 0) {
            return false;
        }
        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            nums.add((double) cards[i]);
        }
        return helper(nums);
    }
    private boolean helper(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 0.001;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            next.add(nums.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            next.add(nums.get(i) + nums.get(j));
                        } else if (k == 1) {
                            next.add(nums.get(i) * nums.get(j));
                        } else if (k == 2) {
                            next.add(nums.get(i) - nums.get(j));
                        } else {
                            if (nums.get(j) != 0) {
                                next.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (helper(next)) {
                            return true;
                        }
                        next.remove(next.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}