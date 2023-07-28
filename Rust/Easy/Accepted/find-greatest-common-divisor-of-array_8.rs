impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let max = nums.iter().max().unwrap();
        let min = nums.iter().min().unwrap();
        let mut i = min.clone();
        while i > 0 {
            if max % i == 0 && min % i == 0 {
                return i;
            }
            i -= 1;
        }
        1
    }
}