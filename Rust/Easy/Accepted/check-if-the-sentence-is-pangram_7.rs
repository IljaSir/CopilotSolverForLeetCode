impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut cnt = vec![0; 26];
        for c in sentence.chars() {
            cnt[(c as u8 - b'a') as usize] += 1;
        }
        cnt.iter().all(|c| *c > 0)
    }
}