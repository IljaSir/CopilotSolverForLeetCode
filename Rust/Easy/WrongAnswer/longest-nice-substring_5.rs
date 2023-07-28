impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let mut res = "".to_string();
        for i in 0..s.len() {
            for j in i..s.len() {
                let mut flag = true;
                let mut cnt = vec![0; 26];
                for k in i..=j {
                    let c = s.as_bytes()[k];
                    if c >= b'a' && c <= b'z' {
                        cnt[(c - b'a') as usize] += 1;
                    } else {
                        cnt[(c - b'A') as usize] += 2;
                    }
                }
                for k in 0..26 {
                    if cnt[k] == 1 || cnt[k] == 2 {
                        flag = false;
                        break;
                    }
                }
                if flag && j - i + 1 > res.len() {
                    res = s[i..=j].to_string();
                }
            }
        }
        res
    }
}