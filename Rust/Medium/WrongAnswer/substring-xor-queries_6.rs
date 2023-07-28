impl Solution {
    pub fn substring_xor_queries(s: String, queries: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = Vec::new();
        let mut s = s.chars().map(|c| c.to_digit(10).unwrap() as i32).collect::<Vec<i32>>();
        let mut sum = vec![0; s.len()];
        sum[0] = s[0];
        for i in 1..s.len() {
            sum[i] = sum[i-1] ^ s[i];
        }
        for q in queries {
            let mut l = -1;
            let mut r = -1;
            for i in 0..s.len() {
                if sum[i] ^ q[0] == q[1] {
                    if l == -1 {
                        l = i as i32;
                    }
                    r = i as i32;
                }
            }
            ans.push(vec![l, r]);
        }
        ans
    }
}