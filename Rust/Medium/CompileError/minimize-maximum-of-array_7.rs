impl Solution {
    pub fn minimize_array_value(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut n = nums.len();
        let mut sum = nums.iter().sum::<i32>();
        let mut min = nums.iter().min().unwrap();
        let mut max = nums.iter().max().unwrap();
        let mut res = *max;
        while *min < *max {
            let mid = (*min + *max) / 2;
            let mut sum = 0;
            let mut i = 0;
            while i < n {
                if nums[i] > mid {
                    sum += nums[i] - mid;
                }
                i += 1;
            }
            if sum >= mid {
                min = &mid;
                res = *min;
            } else {
                max = &mid;
            }
        }
        res
    }
}