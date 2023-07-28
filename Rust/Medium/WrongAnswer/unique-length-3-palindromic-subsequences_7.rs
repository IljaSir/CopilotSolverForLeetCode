impl Solution {
    pub fn count_palindromic_subsequence(s: String) -> i32 {
        
        let mut count = 0;
        let n = s.len();
        let mut dp = vec![vec![0; n]; n];
        let mut map = vec![vec![0; 26]; n];
        let mut v = vec![0; 26];
        for i in 0..n {
            let c = s.chars().nth(i).unwrap() as usize - 'a' as usize;
            v[c] += 1;
            for j in 0..26 {
                map[i][j] = v[j];
            }
        }
        for i in 0..n {
            for j in i+2..n {
                if s.chars().nth(i) == s.chars().nth(j) {
                    for k in 0..26 {
                        if map[i][k] < map[j][k] {
                            count += 1;
                            break;
                        }
                    }
                }
            }
        }
        count
    }
}