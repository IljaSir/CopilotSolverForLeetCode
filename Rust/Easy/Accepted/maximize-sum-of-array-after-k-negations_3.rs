impl Solution {
    pub fn largest_sum_after_k_negations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        let mut k = k;
        nums.sort();
        for i in 0..nums.len() {
            if nums[i] < 0 && k > 0 {
                nums[i] *= -1;
                k -= 1;
            }
        }
        if k > 0 {
            if k % 2 == 1 {
                let mut min = 0;
                for i in 1..nums.len() {
                    if nums[i] < nums[min] {
                        min = i;
                    }
                }
                nums[min] *= -1;
            }
        }
        nums.iter().sum()
    }
}