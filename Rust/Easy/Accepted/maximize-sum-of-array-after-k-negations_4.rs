impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() && i < k as usize && nums[i] < 0 {
            nums[i] = -nums[i];
            i += 1;
        }
        let mut sum = 0;
        let mut min = 100;
        for i in 0..nums.len() {
            sum += nums[i];
            if nums[i] < min {
                min = nums[i];
            }
        }
        if (k - i as i32) % 2 == 1 {
            sum -= min * 2;
        }
        sum
    }
}