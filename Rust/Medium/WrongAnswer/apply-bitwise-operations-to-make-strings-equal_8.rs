impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut target = target.chars().collect::<Vec<char>>();
        let mut s_ones = 0;
        let mut target_ones = 0;
        for i in 0..s.len() {
            if s[i] == '1' { s_ones += 1; }
            if target[i] == '1' { target_ones += 1; }
        }
        s_ones == target_ones
    }
}