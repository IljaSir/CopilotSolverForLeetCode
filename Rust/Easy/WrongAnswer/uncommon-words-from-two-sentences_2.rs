impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut s1 = s1.split_whitespace().collect::<Vec<&str>>();
        let mut s2 = s2.split_whitespace().collect::<Vec<&str>>();
        s1.sort();
        s2.sort();
        let mut res = Vec::new();
        let mut i = 0;
        let mut j = 0;
        while i < s1.len() || j < s2.len() {
            let mut i1 = i;
            let mut j1 = j;
            while i1 < s1.len() && s1[i1] == s1[i] {
                i1 += 1;
            }
            while j1 < s2.len() && s2[j1] == s2[j] {
                j1 += 1;
            }
            if i1 - i == 1 && j1 - j == 0 {
                res.push(s1[i].to_string());
            }
            if i1 - i == 0 && j1 - j == 1 {
                res.push(s2[j].to_string());
            }
            i = i1;
            j = j1;
        }
        res
    }
}