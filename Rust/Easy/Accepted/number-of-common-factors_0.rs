impl Solution {
    pub fn common_factors(a: i32, b: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=a.min(b) {
            if a % i == 0 && b % i == 0 {
                count += 1;
            }
        }
        count
    }
}