impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            let mut k = i;
            while nums[j] * nums[(j + nums[j] as usize) % nums.len()] > 0
                && nums[j] * nums[(k + nums[k] as usize) % nums.len()] > 0
                && nums[j] * nums[(k + nums[k] as usize * 2) % nums.len()] > 0
            {
                j = (j + nums[j] as usize) % nums.len();
                k = (k + nums[k] as usize * 2) % nums.len();
                if j == k {
                    if j == (j + nums[j] as usize) % nums.len() {
                        break;
                    }
                    return true;
                }
            }
            let val = nums[i];
            while nums[i] * val > 0 {
                let next = (i + nums[i] as usize) % nums.len();
                nums[i] = 0;
                i = next;
            }
        }
        false
    }
}