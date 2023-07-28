impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut k = k as usize;
        let mut i = 0;
        let mut j = 0;
        let mut chars = s.chars();
        while j < k {
            if "aeiou".contains(chars.next().unwrap()) {
                count += 1;
            }
            j += 1;
        }
        max = count;
        while let Some(c) = chars.next() {
            if "aeiou".contains(c) {
                count += 1;
            }
            if "aeiou".contains(s.chars().nth(i).unwrap()) {
                count -= 1;
            }
            max = max.max(count);
            i += 1;
            j += 1;
        }
        max
    }
}