impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=n {
            res = ((res << i.to_string(2).len()) + i) % 1_000_000_007;
        }
        res
    }
}