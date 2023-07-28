class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        List<Long> result = new ArrayList<>();
        int[] frequency = new int[100001];
        for (int num : nums) {
            frequency[num]++;
        }
        int[] prefixSum = new int[100001];
        for (int i = 1; i < 100001; i++) {
            prefixSum[i] = prefixSum[i - 1] + frequency[i];
        }
        for (int query : queries) {
            int left = 1, right = 100000, mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (prefixSum[mid] < query) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long answer = 0;
            int index = left;
            while (query > 0) {
                int count = Math.min(frequency[index], query);
                answer += (long) count * Math.abs(index - left);
                query -= count;
                index++;
            }
            result.add(answer);
        }
        return result;
    }
}