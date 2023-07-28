impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut count = 0;
        let mut prev = vec![0; 5];
        for c in word.chars() {
            let i = match c {
                'a' => 0,
                'e' => 1,
                'i' => 2,
                'o' => 3,
                'u' => 4,
                _ => unreachable!(),
            };
            prev[i] += 1;
            count += prev[i];
        }
        count
    }
}