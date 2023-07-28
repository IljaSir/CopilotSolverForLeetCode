impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut map = [0; 26];
        for c in sentence.chars() {
            let idx = c as usize - 97;
            map[idx] = 1;
        }
        map.iter().sum::<i32>() == 26
    }
}