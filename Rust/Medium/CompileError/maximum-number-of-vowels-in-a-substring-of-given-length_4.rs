impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let k = k as usize;
        let s = s.as_bytes();
        while j < s.len() {
            if is_vowel(s[j]) {
                count += 1;
            }
            j += 1;
            if j - i == k {
                max = std::cmp::max(max, count);
                if is_vowel(s[i]) {
                    count -= 1;
                }
                i += 1;
            }
        }
        max
    }
}