impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut i = 1;
        let mut count = 0;
        while count == 0 || i != 1 {
            if i < n / 2 {
                i *= 2;
            } else {
                i = n - i;
            }
            count += 1;
        }
        count
    }
}