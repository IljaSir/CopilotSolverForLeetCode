impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut l = vec![0; 26];
        let mut r = vec![0; 26];
        let mut result = 0;
        for c in s.chars() {
            r[c as usize - 'a' as usize] += 1;
        }
        for c in s.chars() {
            r[c as usize - 'a' as usize] -= 1;
            l[c as usize - 'a' as usize] += 1;
            if l.iter().filter(|&&x| x > 0).count() == r.iter().filter(|&&x| x > 0).count() {
                result += 1;
            }
        }
        result
    }
}