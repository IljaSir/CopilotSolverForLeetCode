impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut i = n;
        while i % 2 != 0 {
            i += n;
        }
        i
    }
}