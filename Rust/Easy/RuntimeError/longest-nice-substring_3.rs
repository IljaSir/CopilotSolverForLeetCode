impl Solution {
    pub fn longest_nice_substring(s: String) -> String {
        
        let s = s.as_bytes();
        let mut ans = String::new();
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, s.len()));
        while let Some((l, r)) = queue.pop_front() {
            let mut count = [0; 26];
            for i in l..r {
                let c = s[i];
                count[(c - b'a') as usize] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if count[i] > 0 && count[i] < 2 {
                    ok = false;
                    break;
                }
            }
            if ok {
                if r - l > ans.len() {
                    ans = String::from_utf8(s[l..r].to_vec()).unwrap();
                }
            } else {
                for i in l..r {
                    if count[(s[i] - b'a') as usize] == 1 {
                        queue.push_back((l, i));
                        queue.push_back((i + 1, r));
                        break;
                    }
                }
            }
        }
        ans
    }
}