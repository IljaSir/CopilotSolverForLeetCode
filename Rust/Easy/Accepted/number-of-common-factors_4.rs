impl Solution {
    pub fn common_factors(a: i32, b: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 1;
        while i <= a {
            if a % i == 0 && b % i == 0 {
                count += 1;
            }
            i += 1;
        }
        count
    }
}