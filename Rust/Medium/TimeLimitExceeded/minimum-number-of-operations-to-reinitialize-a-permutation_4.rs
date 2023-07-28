impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut x = 1;
        let mut count = 0;
        while x != 1 || count == 0 {
            if x < n / 2 {
                x *= 2;
            } else {
                x = n - x;
            }
            count += 1;
        }
        count
    }
}