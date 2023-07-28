impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut ans = 0;
        for i in left..right+1 {
            let word = &words[i as usize];
            for c in word.chars() {
                if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    ans += 1;
                }
            }
        }
        ans
    }
}