impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        for n in nums {
            if n < min {
                min = n;
            }
            if n > max {
                max = n;
            }
        }
        //println!("min: {}, max: {}", min, max);
        let mut gcd = 1;
        for i in 1..=min {
            if min % i == 0 && max % i == 0 {
                gcd = i;
            }
        }
        gcd
    }
}