impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let mut i = 0;
        let mut j = 0;
        let mut max = 0;
        let mut cur = 0;
        let mut s = s.chars().collect::<Vec<_>>();
        while j < s.len() {
            if is_vowel(s[j]) {
                cur += 1;
            }
            if j - i + 1 == k as usize {
                max = max.max(cur);
                if is_vowel(s[i]) {
                    cur -= 1;
                }
                i += 1;
            }
            j += 1;
        }
        max
    }
}