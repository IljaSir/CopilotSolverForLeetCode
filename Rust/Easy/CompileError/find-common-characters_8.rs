impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut ans = vec![];
        let mut first_word = words[0].clone();
        for ch in first_word.chars() {
            let mut flag = true;
            for i in 1..words.len() {
                if !words[i].contains(ch) {
                    flag = false;
                    break;
                }
            }
            if flag {
                ans.push(ch.to_string());
                for i in 1..words.len() {
                    let pos = words[i].find(ch).unwrap();
                    words[i].remove(pos);
                }
            }
        }
        ans
    }
}