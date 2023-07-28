impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 0 {
                    odd += 1;
                }
            } else {
                if nums[i] % 2 == 1 {
                    odd += 1;
                }
            }
        }
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 1 {
                    even += 1;
                }
            } else {
                if nums[i] % 2 == 0 {
                    even += 1;
                }
            }
        }
        odd.min(even)
    }
}