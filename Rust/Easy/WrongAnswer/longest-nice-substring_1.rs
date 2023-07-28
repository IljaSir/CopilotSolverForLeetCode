impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let s = s.as_bytes();
        let mut res = String::new();
        for i in 0..s.len() {
            let mut v = vec![0; 52];
            for j in i..s.len() {
                let c = s[j];
                if c >= b'a' {
                    v[(c - b'a') as usize] |= 1;
                } else {
                    v[(c - b'A' + 26) as usize] |= 2;
                }
                if v.iter().all(|&x| x == 3) {
                    let ss = String::from_utf8(s[i..j+1].to_vec()).unwrap();
                    if ss.len() > res.len() {
                        res = ss;
                    }
                }
            }
        }
        res
    }
}