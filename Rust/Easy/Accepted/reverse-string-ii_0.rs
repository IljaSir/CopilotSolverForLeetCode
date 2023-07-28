impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut s: Vec<char> = s.chars().collect();
        let k = k as usize;
        for i in (0..s.len()).step_by(2 * k) {
            let j = std::cmp::min(i + k, s.len());
            s[i..j].reverse();
        }
        s.into_iter().collect()
    }
}