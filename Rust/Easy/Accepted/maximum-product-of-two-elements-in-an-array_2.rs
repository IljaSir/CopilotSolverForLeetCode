impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max1 = 0;
        let mut max2 = 0;
        for i in nums {
            if i > max1 {
                max2 = max1;
                max1 = i;
            } else if i > max2 {
                max2 = i;
            }
        }
        (max1 - 1) * (max2 - 1)
    }
}