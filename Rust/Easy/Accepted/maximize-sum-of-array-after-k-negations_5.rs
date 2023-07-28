impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        nums.sort();
        let mut i = 0;
        while i < nums.len() && k > 0 {
            if nums[i] < 0 {
                nums[i] = -nums[i];
                k -= 1;
            }
            i += 1;
        }
        if k % 2 == 1 {
            let mut min = 100;
            for i in 0..nums.len() {
                min = min.min(nums[i]);
            }
            for i in 0..nums.len() {
                if nums[i] == min {
                    nums[i] = -nums[i];
                    break;
                }
            }
        }
        nums.iter().sum()
    }
}