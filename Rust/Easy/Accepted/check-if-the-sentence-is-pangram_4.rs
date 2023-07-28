impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut map = [false; 26];
        for c in sentence.as_bytes() {
            map[(c - b'a') as usize] = true;
        }
        map.iter().all(|&x| x)
    }
}