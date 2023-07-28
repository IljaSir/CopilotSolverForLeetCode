impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut count = 0;
        loop {
            let mut has_odd = false;
            for i in 0..nums.len() {
                if nums[i] % 2 == 1 {
                    has_odd = true;
                    nums[i] -= 1;
                    count += 1;
                }
            }
            if !has_odd {
                break;
            }
            for i in 0..nums.len() {
                nums[i] /= 2;
            }
            count += 1;
        }
        count
    }
}