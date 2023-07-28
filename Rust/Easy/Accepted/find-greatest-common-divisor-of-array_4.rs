impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let min = nums.iter().min().unwrap();
        let max = nums.iter().max().unwrap();
        let mut gcd = 1;
        for i in 1..=*min {
            if min % i == 0 && max % i == 0 {
                gcd = i;
            }
        }
        gcd
    }
}