impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let mut count = 0;
        let mut sum = 0;
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        for c in word.chars() {
            if vowels.contains(&c) {
                count += 1;
            }
            sum += count;
        }
        sum
    }
}