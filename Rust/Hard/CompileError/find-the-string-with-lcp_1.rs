impl Solution {
    pub fn find_the_string(lcp: Vec<Vec<i32>>) -> String {
        
        let n = lcp.len();
        let mut s = vec![0; n];
        s[n - 1] = 1;
        for i in (0..n - 1).rev() {
            for j in i + 1..n {
                if lcp[i][j] == j - i {
                    s[i] = s[j] + 1;
                    break;
                }
            }
        }
        let mut res = vec!['a'; n];
        for i in 0..n - 1 {
            res[i] = (b'a' + s[i] as u8) as char;
        }
        res.into_iter().collect()
    }
}