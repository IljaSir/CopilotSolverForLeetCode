impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut res = -1;
        let s: Vec<char> = s.chars().collect();
        for i in 0..s.len() {
            for j in (i+1..s.len()).rev() {
                if s[i] == s[j] {
                    res = res.max((j - i - 1) as i32);
                    break;
                }
            }
        }
        res
    }
}