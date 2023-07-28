impl Solution {
    pub fn max_length_between_equal_characters(s: String) -> i32 {
        
        let mut max = -1;
        for i in 0..s.len() {
            for j in (i+1..s.len()).rev() {
                if s[i..i+1] == s[j..j+1] {
                    max = std::cmp::max(max, (j-i-1) as i32);
                }
            }
        }
        max
    }
}