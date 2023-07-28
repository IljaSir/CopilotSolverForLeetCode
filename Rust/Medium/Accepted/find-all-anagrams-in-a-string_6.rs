impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut res = Vec::new();
        let mut s = s.as_bytes().to_vec();
        let mut p = p.as_bytes().to_vec();
        let mut pmap = [0; 26];
        let mut smap = [0; 26];
        for i in 0..p.len() {
            pmap[(p[i] - b'a') as usize] += 1;
        }
        for i in 0..s.len() {
            smap[(s[i] - b'a') as usize] += 1;
            if i >= p.len() {
                smap[(s[i - p.len()] - b'a') as usize] -= 1;
            }
            if smap == pmap {
                res.push((i - p.len() + 1) as i32);
            }
        }
        res
    }
}