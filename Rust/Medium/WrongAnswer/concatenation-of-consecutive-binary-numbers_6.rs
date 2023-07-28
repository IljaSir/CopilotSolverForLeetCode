impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=n {
            res = (res * (i as i64).leading_zeros() as i64 + i as i64) % 1000000007;
        }
        res as i32
    }
}