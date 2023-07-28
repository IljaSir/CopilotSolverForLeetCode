impl Solution {
    pub fn reinitialize_permutation(n: i32) -> i32 {
        
        let mut res = 0;
        let mut i = 1;
        while {
            i = if i % 2 == 0 { i / 2 } else { n / 2 + (i - 1) / 2 };
            res += 1;
            i != 1
        } {}
        res
    }
}