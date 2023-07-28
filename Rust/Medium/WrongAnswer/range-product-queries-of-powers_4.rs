impl Solution {
    pub fn product_queries(n: i32, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut powers: Vec<i32> = vec![];
        let mut n = n;
        while n > 0 {
            powers.push(n);
            n = n & (n - 1);
        }
        let mut ans: Vec<i32> = vec![];
        for q in queries {
            let mut product: i32 = 1;
            for i in q[0] as usize ..= q[1] as usize {
                product = product * powers[i];
                product = product % 1_000_000_007;
            }
            ans.push(product);
        }
        ans
    }
}