impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let mut v = 0;
        let mut c = 0;
        for i in word.chars() {
            if i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' {
                v += 1;
            }
            c += v;
        }
        c
    }
}