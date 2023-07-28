impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut ans = 0;
        let words: Vec<Vec<char>> = words.iter().map(|x| x.chars().collect()).collect();
        for (i, word1) in words.iter().enumerate() {
            for (j, word2) in words.iter().enumerate() {
                if i == j {
                    continue;
                }
                let mut flag = true;
                for &c in word1.iter() {
                    if word2.contains(&c) {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    ans = ans.max(word1.len() * word2.len());
                }
            }
        }
        ans as i32
    }
}