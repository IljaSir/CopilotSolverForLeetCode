impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                let mut left = 0;
                let mut right = 0;
                let mut j = i;
                while j > 0 && nums[j - 1] % 2 == 0 {
                    j -= 1;
                    left += 1;
                }
                let mut k = i;
                while k < nums.len() - 1 && nums[k + 1] % 2 == 0 {
                    k += 1;
                    right += 1;
                }
                count += (left + 1) * (right + 1) as i64;
            }
        }
        count
    }
}