impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let k = k as usize;
        let mut count = 0;
        for c in s.chars().take(k) {
            if "aeiou".contains(c) {
                count += 1;
            }
        }
        let mut max = count;
        for (i, c) in s.chars().enumerate().skip(k) {
            if "aeiou".contains(c) {
                count += 1;
            }
            if "aeiou".contains(s.chars().nth(i-k).unwrap()) {
                count -= 1;
            }
            max = std::cmp::max(max, count);
        }
        max
    }
}