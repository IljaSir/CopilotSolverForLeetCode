impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        let mut i = 0;
        while i < s.len() {
            let j = i + k;
            let j = if j > s.len() { s.len() } else { j };
            s.replace_range(i..j, &s[i..j].chars().rev().collect::<String>());
            i += 2 * k;
        }
        s
    }
}