impl Solution {
    pub fn count_good_substrings(s: String) -> i32 {
        
        let mut res = 0;
        let chars: Vec<char> = s.chars().collect();
        for i in 0..(chars.len() - 2) {
            if chars[i] != chars[i + 1] && chars[i + 1] != chars[i + 2] && chars[i] != chars[i + 2] {
                res += 1;
            }
        }
        res
    }
}