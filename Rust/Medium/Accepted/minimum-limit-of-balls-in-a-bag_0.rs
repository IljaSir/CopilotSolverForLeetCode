impl Solution {
    pub fn minimum_size(nums: Vec<i32>, max_operations: i32) -> i32 {
        
        let mut left = 1;
        let mut right = *nums.iter().max().unwrap();
        while left < right {
            let mid = left + (right - left) / 2;
            let mut operations = 0;
            for &num in nums.iter() {
                operations += (num - 1) / mid;
            }
            if operations <= max_operations {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}