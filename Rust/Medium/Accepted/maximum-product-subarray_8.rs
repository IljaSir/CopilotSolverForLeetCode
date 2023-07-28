impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = nums[0];
        let mut min = nums[0];
        let mut res = nums[0];
        for i in 1..nums.len() {
            let t = max;
            max = std::cmp::max(std::cmp::max(max * nums[i], min * nums[i]), nums[i]);
            min = std::cmp::min(std::cmp::min(t * nums[i], min * nums[i]), nums[i]);
            res = std::cmp::max(res, max);
        }
        res
    }
}