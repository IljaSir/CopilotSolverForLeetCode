impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut res = vec![s];
        for i in 0..s.len() {
            if s[i..i+1].chars().next().unwrap().is_alphabetic() {
                let n = res.len();
                for j in 0..n {
                    let mut s = res[j].clone();
                    s.replace_range(i..i+1, &s[i..i+1].to_uppercase());
                    res.push(s);
                }
            }
        }
        res
    }
}