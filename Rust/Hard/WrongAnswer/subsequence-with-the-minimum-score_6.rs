impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let s = s.as_bytes();
        let t = t.as_bytes();
        let mut s = s.iter().zip(0..).collect::<Vec<_>>();
        let mut t = t.iter().zip(0..).collect::<Vec<_>>();
        s.sort();
        t.sort();
        let mut i = 0;
        let mut j = 0;
        let mut min = std::i32::MAX;
        let mut max = std::i32::MIN;
        while i < s.len() && j < t.len() {
            if s[i].0 == t[j].0 {
                min = min.min(t[j].1 as i32);
                max = max.max(t[j].1 as i32);
                i += 1;
                j += 1;
            } else if s[i].0 < t[j].0 {
                i += 1;
            } else {
                j += 1;
            }
        }
        if min == std::i32::MAX {
            return 0;
        } else {
            return max - min + 1;
        }
    }
}