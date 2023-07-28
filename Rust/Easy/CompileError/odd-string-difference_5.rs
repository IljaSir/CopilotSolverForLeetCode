impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut count = vec![vec![0; 26]; 2];
        for word in words {
            let mut prev = 0;
            for c in word.bytes() {
                count[(c - b'a') as usize][prev] += 1;
                prev = c - b'a';
            }
        }
        for i in 0..26 {
            if count[i][0] % 2 == 1 {
                return (b'a' + i as u8) as char;
            }
        }
        for i in 0..26 {
            if count[i][1] % 2 == 1 {
                return (b'a' + i as u8) as char;
            }
        }
        "".to_string()
    }
}