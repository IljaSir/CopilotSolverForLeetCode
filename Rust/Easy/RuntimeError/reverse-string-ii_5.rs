impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut s = s;
        let k = k as usize;
        for i in (0..s.len()).step_by(2 * k) {
            let j = i + k;
            let mut t = s[i..j].chars().rev().collect::<String>();
            s.replace_range(i..j, &t);
        }
        s
    }
}