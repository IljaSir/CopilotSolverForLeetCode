impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let mut max = nums[0];
        let mut min = nums[0];
        for i in 1..nums.len() {
            if nums[i] > max {
                max = nums[i];
            }
            if nums[i] < min {
                min = nums[i];
            }
        }
        let mut i = 1;
        let mut gcd = 1;
        while i <= min {
            if min % i == 0 && max % i == 0 {
                gcd = i;
            }
            i += 1;
        }
        gcd
    }
}