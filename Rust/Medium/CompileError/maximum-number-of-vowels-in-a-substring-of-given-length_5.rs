impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let k = k as usize;
        let s = s.as_bytes();
        while right < s.len() {
            if is_vowel(s[right]) {
                count += 1;
            }
            if right - left + 1 == k {
                max = max.max(count);
                if is_vowel(s[left]) {
                    count -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        max
    }
}