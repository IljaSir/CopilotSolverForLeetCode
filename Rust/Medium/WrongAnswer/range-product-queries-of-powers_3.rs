impl Solution {
    pub fn product_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let n = n as u64;
        let mut powers: Vec<u64> = vec![];
        let mut i = 1;
        while i <= n {
            powers.push(i);
            i *= 2;
        }
        let mut ans: Vec<i32> = vec![];
        for q in queries {
            let mut res = 1;
            for i in q[0] as usize..=q[1] as usize {
                res *= powers[i] as i32;
                res %= 1000000007;
            }
            ans.push(res);
        }
        ans
    }
}