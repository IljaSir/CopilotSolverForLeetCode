impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max2 = 0;
        for n in nums {
            if n > max {
                max2 = max;
                max = n;
            } else if n > max2 {
                max2 = n;
            }
        }
        (max - 1) * (max2 - 1)
    }
}