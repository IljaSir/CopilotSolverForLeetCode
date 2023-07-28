impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let min = nums.iter().min().unwrap();
        let max = nums.iter().max().unwrap();
        let mut i = min;
        while i > 0 {
            if min % i == 0 && max % i == 0 {
                return *i;
            }
            i -= 1;
        }
        1
    }
}