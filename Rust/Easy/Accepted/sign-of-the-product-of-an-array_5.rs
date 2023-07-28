impl Solution {
    pub fn array_sign(nums: Vec<i32>) -> i32 {
        
        let mut prod = 1;
        for x in nums {
            if x == 0 {
                return 0;
            }
            if x < 0 {
                prod *= -1;
            }
        }
        prod
    }
}