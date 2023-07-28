impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut i = 2;
        loop {
            if i % n == 0 {
                return i;
            }
            i += 2;
        }
    }
}