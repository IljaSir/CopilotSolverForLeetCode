impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut res = nums[0];
        let mut max = res;
        let mut min = res;
        for i in 1..nums.len() {
            if nums[i] < 0 {
                std::mem::swap(&mut max, &mut min);
            }
            max = std::cmp::max(nums[i], max * nums[i]);
            min = std::cmp::min(nums[i], min * nums[i]);
            res = std::cmp::max(res, max);
        }
        res
    }
}