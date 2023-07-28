impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut n = n;
        while n % 2 != 0 {
            n += 1;
        }
        n
    }
}