impl Solution {
    pub fn longest_substring(s: String, k: i32) -> i32 {
        

        let s = s.as_bytes();
        let mut cnt = vec![0; 26];
        for &c in s {
            cnt[(c - b'a') as usize] += 1;
        }
        let mut split = vec![];
        for i in 0..s.len() {
            if cnt[(s[i] - b'a') as usize] < k {
                split.push(i);
            }
        }
        if split.is_empty() {
            return s.len() as i32;
        }
        split.push(s.len());
        let mut start = 0;
        let mut ans = 0;
        for &i in &split {
            ans = ans.max(Self::longest_substring(String::from_utf8_lossy(&s[start..i]).to_string(), k));
            start = i + 1;
        }
        ans
    }
}