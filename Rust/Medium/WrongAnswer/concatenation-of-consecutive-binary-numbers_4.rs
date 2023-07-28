impl Solution {
    pub fn concatenated_binary(n: i32) -> i32 {
        
        let mut result = 0;
        let mut base = 1;
        for i in 1..=n {
            if i & (i - 1) == 0 {
                base = i;
            }
            result = ((result << i.to_string().len()) + i) % 1000000007;
        }
        result
    }
}