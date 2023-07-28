impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let vowels = ['a', 'e', 'i', 'o', 'u'];
        let mut count = 0;
        for i in 0..word.len() {
            let c = word.chars().nth(i).unwrap();
            if vowels.contains(&c) {
                count += word.len() - i;
            }
        }
        count as i64
    }
}