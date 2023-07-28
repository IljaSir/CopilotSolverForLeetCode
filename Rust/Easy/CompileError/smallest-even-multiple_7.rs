impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut a = 1;
        for i in 1..=n {
            a = (a * i) / gcd(a, i);
        }
        a
    }
}