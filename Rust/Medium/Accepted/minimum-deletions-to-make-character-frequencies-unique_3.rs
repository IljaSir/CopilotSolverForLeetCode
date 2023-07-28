impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[(c as u8 - b'a') as usize] += 1;
        }
        count.sort_unstable_by(|a, b| b.cmp(a));
        let mut res = 0;
        let mut prev = count[0];
        for i in 1..26 {
            if count[i] == 0 {
                break;
            }
            if count[i] >= prev {
                res += count[i] - if prev > 0 { prev - 1 } else { 0 };
                count[i] = if prev > 0 { prev - 1 } else { 0 };
            }
            prev = count[i];
        }
        res
    }
}