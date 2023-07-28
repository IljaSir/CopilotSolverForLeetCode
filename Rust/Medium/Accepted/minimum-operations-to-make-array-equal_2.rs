impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 1;
        while i < n {
            count += n - i;
            i += 2;
        }
        count
    }
}