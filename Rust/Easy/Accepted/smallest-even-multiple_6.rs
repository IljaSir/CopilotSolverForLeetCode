impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut n = n;
        if n % 2 != 0 {
            n *= 2;
        }
        n
    }
}