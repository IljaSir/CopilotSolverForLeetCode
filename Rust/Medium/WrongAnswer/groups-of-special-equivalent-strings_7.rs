impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut r = 0;
        let mut v = vec![false; words.len()];
        for i in 0..words.len() {
            if v[i] {
                continue;
            }
            r += 1;
            for j in i + 1..words.len() {
                if v[j] {
                    continue;
                }
                if Solution::is_special_equiv(&words[i], &words[j]) {
                    v[j] = true;
                }
            }
        }
        r
    }
    fn is_special_equiv(a: &str, b: &str) -> bool {
        let mut ca = [0; 26];
        let mut cb = [0; 26];
        for i in 0..a.len() {
            if i % 2 == 0 {
                ca[a.as_bytes()[i] as usize - 'a' as usize] += 1;
            } else {
                cb[a.as_bytes()[i] as usize - 'a' as usize] += 1;
            }
        }
        for i in 0..b.len() {
            if i % 2 == 0 {
                ca[b.as_bytes()[i] as usize - 'a' as usize] -= 1;
            } else {
                cb[b.as_bytes()[i] as usize - 'a' as usize] -= 1;
            }
        }
        ca == cb
    }
}