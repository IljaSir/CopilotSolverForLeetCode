impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut second = 0;
        for i in nums {
            if i > max {
                second = max;
                max = i;
            } else if i > second {
                second = i;
            }
        }
        (max - 1) * (second - 1)
    }
}