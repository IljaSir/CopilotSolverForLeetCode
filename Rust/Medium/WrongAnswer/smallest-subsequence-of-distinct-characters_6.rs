impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
        
        let mut cnt: Vec<i32> = vec![0; 26];
        let mut visited: Vec<bool> = vec![false; 26];
        let mut ans: Vec<u8> = vec![];
        for c in s.as_bytes() {
            cnt[(c - b'a') as usize] += 1;
        }
        for c in s.as_bytes() {
            let idx = (c - b'a') as usize;
            cnt[idx] -= 1;
            if visited[idx] {
                continue;
            }
            while let Some(&x) = ans.last() {
                if x < *c && cnt[(x - b'a') as usize] > 0 {
                    ans.pop();
                    visited[(x - b'a') as usize] = false;
                } else {
                    break;
                }
            }
            ans.push(*c);
            visited[idx] = true;
        }
        String::from_utf8(ans).unwrap()
    }
}