impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 1;
        loop {
            i = if i % 2 == 0 { i / 2 } else { n / 2 + (i - 1) / 2 };
            count += 1;
            if i == 1 {
                break;
            }
        }
        count
    }
}