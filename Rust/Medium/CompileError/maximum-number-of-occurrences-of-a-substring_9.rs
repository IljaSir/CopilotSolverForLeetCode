impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut count = vec![0; 26];
        let mut total = 0;
        let mut ans = 0;
        let mut map = std::collections::HashMap::new();
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut sub = String::new();
        let mut sub_count = vec![0; 26];
        let mut sub_total = 0;
        let s = s.as_bytes();
        while j < s.len() {
            let c = s[j];
            if count[c as usize - 97] == 0 {
                total += 1;
            }
            count[c as usize - 97] += 1;
            if total <= max_letters {
                if j - i + 1 == min_size as usize {
                    sub.clear();
                    for k in i..j + 1 {
                        sub.push(s[k] as char);
                    }
                    let sub_count = map.entry(sub).or_insert(0);
                    *sub_count += 1;
                    ans = ans.max(*sub_count);
                }
                if j - i + 1 > min_size as usize {
                    let c = s[i];
                    count[c as usize - 97] -= 1;
                    if count[c as usize - 97] == 0 {
                        total -= 1;
                    }
                    i += 1;
                }
            } else {
                while total > max_letters {
                    let c = s[i];
                    count[c as usize - 97] -= 1;
                    if count[c as usize - 97] == 0 {
                        total -= 1;
                    }
                    i += 1;
                }
            }
            j += 1;
        }
        ans
    }
}