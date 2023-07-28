impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        nums.sort();
        let mut i = 0;
        while k > 0 {
            if nums[i] < 0 {
                nums[i] = -nums[i];
                k -= 1;
                i += 1;
            } else {
                break;
            }
        }
        if k > 0 {
            if k % 2 == 1 {
                nums[0] = -nums[0];
            }
        }
        nums.iter().sum()
    }
}