impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        let mut sum = 0;
        nums.sort();
        for i in 0..nums.len() {
            if k == 0 {
                break;
            }
            if nums[i] < 0 {
                nums[i] = -nums[i];
                k -= 1;
            }
        }
        for i in 0..nums.len() {
            if k > 0 && k % 2 == 1 {
                if i == 0 {
                    nums[i] = -nums[i];
                } else if nums[i] > nums[i - 1] {
                    nums[i - 1] = -nums[i - 1];
                } else {
                    nums[i] = -nums[i];
                }
            }
            sum += nums[i];
        }
        sum
    }
}