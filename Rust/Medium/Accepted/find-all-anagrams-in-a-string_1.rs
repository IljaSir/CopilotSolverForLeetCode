impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let s = s.as_bytes();
        let p = p.as_bytes();
        let mut p_count = vec![0; 26];
        for &c in p {
            p_count[(c - b'a') as usize] += 1;
        }
        let mut s_count = vec![0; 26];
        let mut result = vec![];
        for i in 0..s.len() {
            s_count[(s[i] - b'a') as usize] += 1;
            if i >= p.len() {
                s_count[(s[i - p.len()] - b'a') as usize] -= 1;
            }
            if s_count == p_count {
                result.push((i - p.len() + 1) as i32);
            }
        }
        result
    }
}