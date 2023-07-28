impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        
        let mut sum = 0;
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut result = -1;
        let mut min = 0;
        while i <= j {
            if sum < x {
                sum += nums[i];
                i += 1;
            } else if sum > x {
                sum -= nums[j];
                j -= 1;
            } else if sum == x {
                if result == -1 {
                    min = i + nums.len() - j - 1;
                } else {
                    min = min.min(i + nums.len() - j - 1);
                }
                sum += nums[i];
                i += 1;
            }
        }
        if sum == x {
            if result == -1 {
                min = i + nums.len() - j - 1;
            } else {
                min = min.min(i + nums.len() - j - 1);
            }
        }
        if min == 0 {
            -1
        } else {
            min as i32
        }
    }
}