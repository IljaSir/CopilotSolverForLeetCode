impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = nums[0];
        let mut min = nums[0];
        let mut result = nums[0];
        for i in 1..nums.len() {
            let temp = max;
            max = std::cmp::max(std::cmp::max(max * nums[i], min * nums[i]), nums[i]);
            min = std::cmp::min(std::cmp::min(temp * nums[i], min * nums[i]), nums[i]);
            result = std::cmp::max(result, max);
        }
        result
    }
}