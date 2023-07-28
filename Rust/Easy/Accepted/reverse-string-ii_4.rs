impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut v: Vec<char> = s.chars().collect();
        let k = k as usize;
        let mut i = 0;
        while i < v.len() {
            let s = i;
            let e = if i + k < v.len() { i + k } else { v.len() };
            v[s..e].reverse();
            i += 2 * k;
        }
        v.into_iter().collect()
    }
}