impl Solution {
    pub fn max_rep_opt1(text: String) -> i32 {
        
        let s = text.as_bytes();
        let mut cnt = vec![0; 26];
        for &c in s {
            cnt[(c - b'a') as usize] += 1;
        }
        let mut res = 0;
        let mut i = 0;
        while i < s.len() {
            let j = i + 1;
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            let mut k = j;
            while k < s.len() && s[k] != s[i] && cnt[(s[k] - b'a') as usize] > 1 {
                k += 1;
            }
            res = res.max(j - i + k - j);
            i = j;
        }
        res as i32
    }
}