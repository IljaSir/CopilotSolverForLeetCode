impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut res = String::from("");
        let mut i = 0;
        let mut k = k as usize;
        while i < s.len() {
            let mut t = s[i..std::cmp::min(i + k, s.len())].chars().rev().collect::<String>();
            if i + k < s.len() {
                t += &s[i + k..std::cmp::min(i + 2 * k, s.len())];
            }
            res += &t;
            i += 2 * k;
        }
        res
    }
}