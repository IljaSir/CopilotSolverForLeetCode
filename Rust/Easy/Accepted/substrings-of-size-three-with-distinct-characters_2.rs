impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let mut ans = 0;
        let bytes = s.as_bytes();
        for i in 2..bytes.len() {
            if bytes[i] != bytes[i - 1] && bytes[i] != bytes[i - 2] && bytes[i - 1] != bytes[i - 2] {
                ans += 1;
            }
        }
        ans
    }
}