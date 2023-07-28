impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        let mut count = 0;
        for (i, c) in word.chars().enumerate() {
            if vowels.contains(&c) {
                count += (i + 1) * (word.len() - i);
            }
        }
        count as i64
    }
}