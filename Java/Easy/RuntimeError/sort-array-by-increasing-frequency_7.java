class Solution {
    public int[] frequencySort(int[] nums) {
        
        int[] result = new int[nums.length];
        int[] count = new int[201];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 100]++;
        }
        int[] tmp = new int[nums.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 201;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            int j = 0;
            while (j < tmp.length) {
                if (tmp[j] == 201) {
                    tmp[j] = i - 100;
                    break;
                }
                if (count[tmp[j] + 100] < count[i]) {
                    int t = tmp[j];
                    tmp[j] = i - 100;
                    i = t + 100;
                }
                j++;
            }
        }
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 201) {
                break;
            }
            for (int j = 0; j < count[tmp[i] + 100]; j++) {
                result[index++] = tmp[i];
            }
        }
        return result;
    }
}