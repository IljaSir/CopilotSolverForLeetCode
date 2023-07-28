impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut min = 1000;
        let mut res = 0;
        for i in 0..nums.len() - 2 {
            let mut left = i + 1;
            let mut right = nums.len() - 1;
            while left < right {
                let sum = nums[i] + nums[left] + nums[right];
                let diff = (target - sum).abs();
                if diff < min {
                    min = diff;
                    res = sum;
                }
                if sum < target {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        res
    }
}