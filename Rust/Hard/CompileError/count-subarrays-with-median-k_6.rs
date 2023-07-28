impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut res = 0;
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        while right < nums.len() {
            if nums[right] < k {
                right += 1;
            } else if nums[right] == k {
                count += 1;
                right += 1;
            } else {
                while left < right && count == 0 {
                    if nums[left] < k {
                        left += 1;
                    } else if nums[left] == k {
                        count -= 1;
                        left += 1;
                    } else {
                        left += 1;
                    }
                }
                if count > 0 {
                    res += 1;
                    count -= 1;
                }
                right += 1;
            }
            if count > 0 {
                res += 1;
            }
        }
        res
    }
}