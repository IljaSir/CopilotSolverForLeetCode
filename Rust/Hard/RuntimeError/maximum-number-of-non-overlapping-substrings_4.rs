impl Solution {
    pub fn max_num_of_substrings(s: String) -> Vec<String> {
        
        let mut ans = vec![];
        let mut last = vec![0; 26];
        let mut visited = vec![false; 26];
        let mut left = vec![0; 26];
        let mut right = vec![0; 26];
        let mut stack = vec![];
        let mut pos = 0;
        for c in s.chars() {
            last[c as usize - 'a' as usize] = pos;
            pos += 1;
        }
        for c in s.chars() {
            let i = c as usize - 'a' as usize;
            if visited[i] {
                continue;
            }
            visited[i] = true;
            left[i] = pos;
            right[i] = pos;
            stack.push(i);
            while let Some(j) = stack.pop() {
                left[i] = left[i].min(left[j]);
                right[i] = right[i].max(right[j]);
                let c = (s.as_bytes()[right[i]] as char).to_string();
                if let Some(&k) = last.get(c.as_bytes()[0] as usize - 'a' as usize) {
                    if k > right[i] {
                        stack.push(k as usize - 'a' as usize);
                    }
                }
            }
            pos += 1;
        }
        let mut i = 0;
        while i < 26 {
            if visited[i] {
                ans.push(s[left[i]..right[i] + 1].to_string());
                i = right[i] + 1;
            } else {
                i += 1;
            }
        }
        ans
    }
}