impl Solution {
    pub fn max_num_of_substrings(s: String) -> Vec<String> {
        
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        for (i, c) in s.chars().enumerate() {
            let idx = c as usize - 'a' as usize;
            if left[idx] == 0 {
                left[idx] = i + 1;
            }
            right[idx] = i + 1;
        }
        let mut ans = Vec::new();
        let mut cur = String::new();
        let mut l = 0;
        let mut r = 0;
        let mut i = 0;
        while i < s.len() {
            let c = s[i..i+1].to_string();
            if cur.contains(&c) {
                i += 1;
                continue;
            }
            let idx = c.chars().next().unwrap() as usize - 'a' as usize;
            let mut j = left[idx] - 1;
            while j < right[idx] {
                let c = s[j..j+1].to_string();
                if !cur.contains(&c) {
                    cur.push_str(&c);
                    l = l.min(left[c.chars().next().unwrap() as usize - 'a' as usize] - 1);
                    r = r.max(right[c.chars().next().unwrap() as usize - 'a' as usize] - 1);
                }
                j += 1;
            }
            if i == r {
                ans.push(s[l..r+1].to_string());
                cur = String::new();
            }
            i += 1;
        }
        ans
    }
}