impl Solution {
    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        
        let mut broken = [false; 26];
        for c in broken_letters.chars() {
            broken[c as usize - 'a' as usize] = true;
        }
        let mut res = 0;
        for word in text.split(' ') {
            if word.chars().all(|c| !broken[c as usize - 'a' as usize]) {
                res += 1;
            }
        }
        res
    }
}