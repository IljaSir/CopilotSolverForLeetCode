impl Solution {
    pub fn smallest_even_multiple(n: i32) -> i32 {
        
        let mut res = n;
        while res % 2 != 0 {
            res += n;
        }
        res
    }
}