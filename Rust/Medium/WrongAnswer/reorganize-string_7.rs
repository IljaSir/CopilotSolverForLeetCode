impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut s = s;
        let mut cs = s.chars().collect::<Vec<char>>();
        cs.sort();
        let mut res = vec![];
        let mut i = 0;
        while i < cs.len() {
            let mut j = i + 1;
            while j < cs.len() && cs[j] == cs[i] {
                j += 1;
            }
            if j == cs.len() {
                if res.len() % 2 == 0 {
                    res.push(cs[i]);
                } else {
                    break;
                }
            } else {
                res.push(cs[i]);
                res.push(cs[j]);
                i = j + 1;
            }
        }
        if res.len() == cs.len() {
            res.iter().collect()
        } else {
            "".to_string()
        }
    }
}