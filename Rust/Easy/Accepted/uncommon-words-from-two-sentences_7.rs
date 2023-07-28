impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut words = s1.split(" ").chain(s2.split(" ")).collect::<Vec<_>>();
        words.sort();
        let mut res = vec![];
        let mut i = 0;
        while i < words.len() {
            let mut j = i;
            while j < words.len() && words[i] == words[j] {
                j += 1;
            }
            if j - i == 1 {
                res.push(words[i].to_string());
            }
            i = j;
        }
        res
    }
}