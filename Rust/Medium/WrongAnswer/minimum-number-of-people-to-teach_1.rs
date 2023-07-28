impl Solution {
    pub fn minimum_teachings(n: i32, languages: Vec<Vec<i32>>, friendships: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut langs = vec![vec![]; n];
        for i in 0..languages.len() {
            for j in 0..languages[i].len() {
                langs[(languages[i][j] - 1) as usize].push(i);
            }
        }
        let mut ans = 0;
        for i in 0..friendships.len() {
            let (u, v) = (friendships[i][0] as usize - 1, friendships[i][1] as usize - 1);
            let mut flag = false;
            for j in 0..n {
                if langs[j].contains(&u) && langs[j].contains(&v) {
                    flag = true;
                    break;
                }
            }
            if !flag {
                ans += 1;
            }
        }
        ans
    }
}