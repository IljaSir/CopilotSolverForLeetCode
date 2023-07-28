impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut ret = Vec::new();
        let mut s = s.as_bytes().to_vec();
        let mut p = p.as_bytes().to_vec();
        let mut p_count = vec![0; 26];
        let mut s_count = vec![0; 26];
        for i in 0..p.len() {
            p_count[(p[i] - b'a') as usize] += 1;
        }
        for i in 0..s.len() {
            s_count[(s[i] - b'a') as usize] += 1;
            if i >= p.len() {
                s_count[(s[i - p.len()] - b'a') as usize] -= 1;
            }
            if p_count == s_count {
                ret.push((i - p.len() + 1) as i32);
            }
        }
        ret
    }
}