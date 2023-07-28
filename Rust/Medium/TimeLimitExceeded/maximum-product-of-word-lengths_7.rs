impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut words = words;
        let mut result = 0;
        for i in 0..words.len() {
            for j in i..words.len() {
                let mut flag = true;
                for c in words[i].chars() {
                    if words[j].contains(c) {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    result = result.max(words[i].len() * words[j].len());
                }
            }
        }
        result as i32
    }
}