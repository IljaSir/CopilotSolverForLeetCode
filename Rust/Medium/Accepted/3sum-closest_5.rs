impl Solution {
    pub fn three_sum_closest(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut res = nums[0] + nums[1] + nums[2];
        for i in 0..nums.len() {
            let mut l = i + 1;
            let mut r = nums.len() - 1;
            while l < r {
                let sum = nums[i] + nums[l] + nums[r];
                if (target - sum).abs() < (target - res).abs() {
                    res = sum;
                }
                if sum > target {
                    r -= 1;
                } else {
                    l += 1;
                }
            }
        }
        res
    }
}