impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut max = 0;
        let mut count = 0;
        for i in 0..s.len() {
            if i < k as usize {
                if s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' {
                    count += 1;
                }
            } else {
                if s[i - k as usize] == 'a' || s[i - k as usize] == 'e' || s[i - k as usize] == 'i' || s[i - k as usize] == 'o' || s[i - k as usize] == 'u' {
                    count -= 1;
                }
                if s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' {
                    count += 1;
                }
            }
            max = max.max(count);
        }
        max
    }
}