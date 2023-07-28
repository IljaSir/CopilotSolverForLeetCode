impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut res = Vec::new();
        for i in 0..s.len() {
            let mut seen = [false; 26];
            let mut ok = true;
            for j in i..s.len() {
                let c = s[j];
                if c.is_ascii_uppercase() {
                    seen[(c - b'A') as usize] = true;
                } else {
                    seen[(c - b'a') as usize] = true;
                }
                if seen.iter().all(|&x| x) {
                    if res.len() < j - i + 1 {
                        res = s[i..j + 1].to_vec();
                    }
                } else {
                    ok = false;
                }
            }
            if ok {
                break;
            }
        }
        String::from_utf8(res).unwrap()
    }
}