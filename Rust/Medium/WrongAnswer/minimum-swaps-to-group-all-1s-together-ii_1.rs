impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut ones = 0;
        for i in 0..n {
            if nums[i] == 1 {
                ones += 1;
            }
        }
        let mut left = 0;
        let mut right = ones;
        let mut sum = 0;
        for i in 0..right {
            if nums[i] == 1 {
                sum += 1;
            }
        }
        let mut min = ones - sum;
        while right < n {
            if nums[left] == 1 {
                sum -= 1;
            }
            if nums[right] == 1 {
                sum += 1;
            }
            min = min.min(ones - sum);
            left += 1;
            right += 1;
        }
        min as i32
    }
}