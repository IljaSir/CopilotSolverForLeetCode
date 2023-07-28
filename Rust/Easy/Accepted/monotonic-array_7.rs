impl Solution {
    pub fn is_monotonic(nums: Vec<i32>) -> bool {
        
        let mut prev = nums[0];
        let mut is_increasing = None;
        for num in nums.into_iter().skip(1) {
            if is_increasing.is_none() {
                if num > prev {
                    is_increasing = Some(true);
                } else if num < prev {
                    is_increasing = Some(false);
                }
            } else if is_increasing.unwrap() && num < prev {
                return false;
            } else if !is_increasing.unwrap() && num > prev {
                return false;
            }
            prev = num;
        }
        true
    }
}