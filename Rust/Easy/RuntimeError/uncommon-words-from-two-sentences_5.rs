impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut s1 = s1.split_whitespace().collect::<Vec<&str>>();
        let mut s2 = s2.split_whitespace().collect::<Vec<&str>>();
        let mut ret = Vec::new();
        for i in 0..s1.len() {
            let mut j = 0;
            while j < s2.len() {
                if s1[i] == s2[j] {
                    s1.remove(i);
                    s2.remove(j);
                    break;
                }
                j += 1;
            }
        }
        for i in s1 {
            ret.push(i.to_string());
        }
        for i in s2 {
            ret.push(i.to_string());
        }
        ret
    }
}