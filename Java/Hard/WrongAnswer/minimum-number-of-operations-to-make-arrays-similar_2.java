class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] - target[i];
        }
        return sum;
    }
    public int minOperations(int[] nums, int[] target) {
        long sum = makeSimilar(nums, target);
        if(sum % 2 != 0) return -1;
        sum /= 2;
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int p = 0;
        int q = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] > target[i]) {
                a[p++] = nums[i] - target[i];
            } else {
                b[q++] = target[i] - nums[i];
            }
        }
        Arrays.sort(a, 0, p);
        Arrays.sort(b, 0, q);
        int i = p - 1;
        int j = q - 1;
        int count = 0;
        while(sum != 0) {
            if(i < 0 && j < 0) return -1;
            if(i < 0) {
                sum -= b[j--];
            } else if(j < 0) {
                sum -= a[i--];
            } else {
                if(a[i] > b[j]) {
                    sum -= a[i--];
                } else {
                    sum -= b[j--];
                }
            }
            count++;
        }
        return count;
    }
}