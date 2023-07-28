impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let (mut w1, mut w2) = (word1.into_bytes(), word2.into_bytes());
        let (mut i, mut j) = (0, 0);
        let mut res = Vec::new();
        while i < w1.len() || j < w2.len() {
            if i == w1.len() {
                res.push(w2[j]);
                j += 1;
            } else if j == w2.len() {
                res.push(w1[i]);
                i += 1;
            } else if w1[i] > w2[j] {
                res.push(w1[i]);
                i += 1;
            } else if w1[i] < w2[j] {
                res.push(w2[j]);
                j += 1;
            } else {
                if w1[i..].iter().zip(w2[j..].iter()).all(|(a, b)| a == b) {
                    res.push(w1[i]);
                    i += 1;
                } else if w1[i..].iter().zip(w2[j..].iter()).all(|(a, b)| a >= b) {
                    res.push(w1[i]);
                    i += 1;
                } else {
                    res.push(w2[j]);
                    j += 1;
                }
            }
        }
        String::from_utf8(res).unwrap()
    }
}