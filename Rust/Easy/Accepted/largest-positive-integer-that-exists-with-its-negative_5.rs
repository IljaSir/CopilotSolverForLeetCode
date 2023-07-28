impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut max_k = -1;
        for i in 0..nums.len() {
            if nums[i] > 0 {
                if nums.contains(&-nums[i]) {
                    if nums[i] > max_k {
                        max_k = nums[i];
                    }
                }
            }
        }
        max_k
    }
}