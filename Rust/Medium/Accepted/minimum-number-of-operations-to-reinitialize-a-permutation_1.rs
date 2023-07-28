impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut i = 1;
        let mut count = 0;
        while i != 1 || count == 0 {
            if i < n / 2 {
                i *= 2;
            } else {
                i = (i - n / 2) * 2 + 1;
            }
            count += 1;
        }
        count
    }
}