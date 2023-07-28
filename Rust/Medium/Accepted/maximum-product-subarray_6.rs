impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = nums[0];
        let mut min = nums[0];
        let mut res = nums[0];
        for i in 1..nums.len() {
            let tmp = max;
            max = std::cmp::max(std::cmp::max(nums[i], nums[i] * max), nums[i] * min);
            min = std::cmp::min(std::cmp::min(nums[i], nums[i] * tmp), nums[i] * min);
            res = std::cmp::max(res, max);
        }
        res
    }
}