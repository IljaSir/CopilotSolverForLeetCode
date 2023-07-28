impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        

        let mut max = nums[0];
        let mut min = nums[0];
        let mut res = nums[0];
        for i in 1..nums.len() {
            let a = nums[i] * max;
            let b = nums[i] * min;
            max = a.max(b).max(nums[i]);
            min = a.min(b).min(nums[i]);
            res = res.max(max);
        }
        res
    }
}