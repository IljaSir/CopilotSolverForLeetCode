impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max: i32 = nums[0];
        let mut min: i32 = nums[0];
        let mut res: i32 = nums[0];
        for i in 1..nums.len() {
            let tmp = max;
            max = std::cmp::max(nums[i], std::cmp::max(min * nums[i], max * nums[i]));
            min = std::cmp::min(nums[i], std::cmp::min(min * nums[i], tmp * nums[i]));
            res = std::cmp::max(res, max);
        }
        res
    }
}