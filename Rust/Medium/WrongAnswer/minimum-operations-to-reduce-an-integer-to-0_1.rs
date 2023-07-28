impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let mut res = 0;
        let mut i = 1;
        while i < n {
            res += n - i;
            i += 2;
        }
        res
    }
}