impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let product = (nums[i] - 1) * (nums[j] - 1);
                if product > max {
                    max = product;
                }
            }
        }
        max
    }
}