class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = nums[i];
                evenIndex++;
            } else {
                odd[oddIndex] = nums[i];
                oddIndex++;
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        int[] result = new int[nums.length];
        evenIndex = 0;
        oddIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = even[evenIndex];
                evenIndex++;
            } else {
                result[i] = odd[oddIndex];
                oddIndex++;
            }
        }
        return result;
    }
}
    }
}