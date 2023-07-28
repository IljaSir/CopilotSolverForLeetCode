impl Solution {
    pub fn array_sign(nums: Vec<i32>) -> i32 {
        
        let mut product = 1;
        for num in nums {
            product *= num;
        }
        if product < 0 {
            -1
        } else if product > 0 {
            1
        } else {
            0
        }
    }
}