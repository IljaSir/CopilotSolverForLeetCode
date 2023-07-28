impl Solution {
    pub fn common_factors(a: i32, b: i32) -> i32 {
        
        if a == 0 || b == 0 {
            return 0;
        }
        let mut count = 0;
        for i in 1..=a {
            if a % i == 0 && b % i == 0 {
                count += 1;
            }
        }
        count
    }
}