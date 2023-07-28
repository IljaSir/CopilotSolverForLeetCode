impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words = words.iter().map(|s| s.as_bytes().to_vec()).collect::<Vec<Vec<u8>>>();
        words.sort_by_key(|x| x.len());
        let mut res = Vec::new();
        for i in 0..words.len() {
            if Solution::is_concatenated(&words[i], &words[0..i]) {
                res.push(String::from_utf8(words[i].clone()).unwrap());
            }
        }
        res
    }
    fn is_concatenated(word: &Vec<u8>, words: &[Vec<u8>]) -> bool {
        let mut dp = vec![false; word.len() + 1];
        dp[0] = true;
        for i in 1..=word.len() {
            for j in 0..i {
                if dp[j] && words.binary_search(&word[j..i]).is_ok() {
                    dp[i] = true;
                    break;
                }
            }
        }
        dp[word.len()]
    }
}