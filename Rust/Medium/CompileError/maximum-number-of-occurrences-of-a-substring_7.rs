impl Solution {
    pub fn max_freq(s: String, max_letters: i32, min_size: i32, max_size: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut res = 0;
        for i in 0..s.len() {
            let mut letters = std::collections::HashSet::new();
            let mut cnt = 0;
            for j in i..s.len() {
                if cnt == max_size {
                    break;
                }
                let c = s.chars().nth(j).unwrap();
                if !letters.contains(&c) {
                    letters.insert(c);
                }
                if letters.len() > max_letters as usize {
         es
    }
}