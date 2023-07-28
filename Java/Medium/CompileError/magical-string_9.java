class Solution {
    public int magicalString(int n) {
        
        if (n < 1) {
            return 0;
        }
        int[] nums = new int[n];
        int count = 1;
        int index = 1;
        int next = 1;
        nums[0] = 1;
        while (index < n) {
            for (int i = 0; i < nums[next]; i++) {
                if (index >= n) {
                    break;
                }
                nums[index] = 3 - nums[index - 1];
                if (nums[index] == 1) {
                    count++;
                }
                index++;
            }
            next++;
        }
        return coun+] = num;
                if (num == 1 && j < n) res++;
            }
            num = 3 - num;
            i++;
        }
        return res;
    }
}