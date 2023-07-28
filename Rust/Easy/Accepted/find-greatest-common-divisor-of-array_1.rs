impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        for i in nums {
            if i < min {
                min = i;
            }
            if i > max {
                max = i;
            }
        }
        let mut gcd = 1;
        for i in 2..min+1 {
            if min % i == 0 && max % i == 0 {
                gcd = i;
            }
        }
        gcd
    }
}