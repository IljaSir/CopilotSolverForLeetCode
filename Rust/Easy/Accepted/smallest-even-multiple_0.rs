impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut i = 1;
        while i % 2 != 0 || i % n != 0 {
            i += 1;
        }
        i
    }
}