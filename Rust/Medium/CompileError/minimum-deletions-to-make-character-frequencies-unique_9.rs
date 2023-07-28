impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut count = [0; 26];
        for c in s.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        count.sort_unstable_by_key(|&x| Reverse(x));
        let mut ret = 0;
        let mut prev = count[0];
        for i in 1..count.len() {
            if count[i] == 0 {
                break;
            }
            if count[i] >= prev {
                ret += count[i] - prev + 1;
                count[i] = prev - 1;
            }
            prev = count[i];
        }
        ret
    }
}