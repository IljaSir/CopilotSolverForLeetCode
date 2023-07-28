impl Solution {
    pub fn find_substring(s: String, words: Vec<String>) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![];
        let s = s.as_bytes();
        let mut words = words;
        words.sort();
        let words_len = words.len();
        let word_len = words[0].len();
        let s_len = s.len();
        let mut i = 0;
        while i + word_len * words_len <= s_len {
            let mut temp = vec![];
            let mut j = i;
            while j + word_len <= s_len {
                temp.push(String::from_utf8(s[j..j+word_len].to_vec()).unwrap());
                j += word_len;
            }
            temp.sort();
            if temp == words {
                res.push(i as i32);
            }
            i += 1;
        }
        res
    }
}