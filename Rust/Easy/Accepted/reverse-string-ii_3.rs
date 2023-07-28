impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut chars: Vec<char> = s.chars().collect();
        let mut i: usize = 0;
        let mut j: usize = 0;
        let k = k as usize;
        while j < chars.len() {
            i = j;
            j += k;
            if j > chars.len() {
                j = chars.len();
            }
            chars[i..j].reverse();
            j += k;
        }
        chars.into_iter().collect()
    }
}