class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int[] first = new int[nums.length / 2];
        int[] second = new int[nums.length - first.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < first.length) {
                first[i] = nums[i];
            } else {
                second[i - first.length] = nums[i];
            }
        }

        List<Integer> firstSum = new ArrayList<>();
        List<Integer> secondSum = new ArrayList<>();

        generate(first, 0, 0, firstSum);
        generate(second, 0, 0, secondSum);

        Collections.sort(firstSum);
        Collections.sort(secondSum);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < firstSum.size(); i++) {
            int j = Collections.binarySearch(secondSum, goal - firstSum.get(i));
            if (j >= 0) {
                return 0;
            } else {
                j = -j - 1;
                if (j < secondSum.size()) {
                    min = Math.min(min, Math.abs(goal - firstSum.get(i) - secondSum.get(j)));
                }
                if (j > 0) {
                    min = Math.min(min, Math.abs(goal - firstSum.get(i) - secondSum.get(j - 1)));
                }
            }
        }

        return min;
    }

    private void generate(int[] nums, int index, int sum, List<Integer> result) {
        if (index == nums.length) {
            result.add(sum);
            return;
        }

        generate(nums, index + 1, sum + nums[index], result);
        generate(nums, index + 1, sum, result);
    }
}