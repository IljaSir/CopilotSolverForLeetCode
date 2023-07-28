impl Solution {
    pub fn max_num_of_substrings(s: String) -> Vec<String> {
        
        let mut left = vec![s.len(); 26];
        let mut right = vec![0; 26];
        let mut ans = vec![];
        let bytes = s.as_bytes();
        for (i, &b) in bytes.iter().enumerate() {
            let idx = (b - b'a') as usize;
            left[idx] = left[idx].min(i);
            right[idx] = right[idx].max(i);
        }
        let mut i = 0;
        while i < s.len() {
            let idx = (bytes[i] - b'a') as usize;
            let mut j = left[idx];
            let mut k = right[idx];
            while j < k {
                let idx = (bytes[j] - b'a') as usize;
                k = k.max(right[idx]);
                j += 1;
            }
            ans.push(s[i..=k].to_string());
            i = k + 1;
        }
        ans
    }
}