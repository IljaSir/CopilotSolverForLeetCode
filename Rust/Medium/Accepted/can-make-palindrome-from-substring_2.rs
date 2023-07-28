impl Solution {
    pub fn can_make_pali_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut ans = vec![];
        let mut v = vec![vec![0; 26]; s.len()+1];
        for i in 0..s.len() {
            v[i+1] = v[i].clone();
            v[i+1][s.as_bytes()[i] as usize - 'a' as usize] += 1;
        }
        for q in queries {
            let mut cnt = 0;
            for i in 0..26 {
                cnt += (v[q[1] as usize + 1][i] - v[q[0] as usize][i]) % 2;
            }
            ans.push(cnt / 2 <= q[2]);
        }
        ans
    }
}