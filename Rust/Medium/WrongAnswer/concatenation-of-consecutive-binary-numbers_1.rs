impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut res = 0;
        for i in 1..=n {
            let mut j = i;
            while j > 0 {
                res = (res * 2 + j % 2) % 1000000007;
                j /= 2;
            }
        }
        res
    }
}