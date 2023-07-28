impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut words: Vec<Vec<char>> = words.iter().map(|s| s.chars().collect()).collect();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut max = 0;
        for i in 0..words.len() {
            for j in i + 1..words.len() {
                let mut flag = true;
                for c in &words[i] {
                    if words[j].contains(&c) {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    max = max.max(words[i].len() * words[j].len());
                }
            }
        }
        max as i32
    }
}