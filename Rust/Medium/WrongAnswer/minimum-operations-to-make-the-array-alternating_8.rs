impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        let mut i = 0;
        while i < nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 != 0 {
                    odd += 1;
                } else {
                    even += 1;
                }
            } else {
                if nums[i] % 2 == 0 {
                    odd += 1;
                } else {
                    even += 1;
                }
            }
            i += 1;
        }
        if odd > even {
            even
        } else {
            odd
        }
    }
}