impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let mut min = nums[0];
        let mut max = nums[0];
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
            }
            if nums[i] > max {
                max = nums[i];
            }
        }
        let mut gcd = 1;
        for i in 1..min+1 {
            if min % i == 0 && max % i == 0 {
                gcd = i;
            }
        }
        gcd
    }
}