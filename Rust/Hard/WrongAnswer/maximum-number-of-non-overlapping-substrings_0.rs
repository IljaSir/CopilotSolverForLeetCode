impl Solution {
    pub fn max_num_of_substrings(s: String) -> Vec<String> {
        
        let mut last = vec![0; 26];
        let s = s.as_bytes();
        for i in 0..s.len() {
            last[(s[i] - b'a') as usize] = i;
        }
        let mut ans = Vec::new();
        let mut start = 0;
        while start < s.len() {
            let mut end = last[(s[start] - b'a') as usize];
            let mut i = start;
            while i <= end {
                end = end.max(last[(s[i] - b'a') as usize]);
                i += 1;
            }
            let mut j = start;
            while j < end {
                if last[(s[j] - b'a') as usize] > end {
                    start = j + 1;
                    end = 0;
                    break;
                }
                j += 1;
            }
            if end > 0 {
                ans.push(String::from_utf8(s[start..=end].to_vec()).unwrap());
                start = end + 1;
            }
        }
        ans
    }
}