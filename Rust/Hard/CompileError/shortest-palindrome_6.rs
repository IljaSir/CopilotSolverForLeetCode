impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let n = s.len();
        let mut rev = s.clone();
        rev.reverse();
        let mut s = s.iter().chain(&['#']).chain(rev.iter()).collect::<String>();
        let n = s.len();
        let mut f = vec![0; n];
        for i in 1..n {
            let mut j = f[i-1];
            while j > 0 && s.chars().nth(i) != s.chars().nth(j) {
                j = f[j-1];
            }
            if s.chars().nth(i) == s.chars().nth(j) {
                j += 1;
            }
            f[i] = j;
        }
        let mut res = s.chars().skip(n/2).collect::<String>();
        res.reverse();
        res = res.chars().chain(s.chars().skip(f[n-1])).collect::<String>();
        res
    }
}