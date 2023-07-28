impl Solution {
    pub fn find_anagrams(s: String, p: String) -> Vec<i32> {
        

        let mut result = vec![];
        let (p, s) = (p.as_bytes(), s.as_bytes());
        let (mut start, mut end) = (0, 0);
        let mut pmap = vec![0; 26];
        let mut smap = vec![0; 26];
        for c in p {
            pmap[(c - b'a') as usize] += 1;
        }
        while end < s.len() {
            smap[(s[end] - b'a') as usize] += 1;
            if end - start + 1 > p.len() {
                smap[(s[start] - b'a') as usize] -= 1;
                start += 1;
            }
            if smap == pmap {
                result.push(start as i32);
            }
            end += 1;
        }
        result
    }
}