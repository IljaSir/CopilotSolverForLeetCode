impl Solution {
    pub fn lexical_order(n: i32) -> Vec<i32> {
        

        let mut result = Vec::new();
        let mut cur = 1;
        for _ in 0..n {
            result.push(cur);
            if cur * 10 <= n {
                cur *= 10;
            } else if cur % 10 != 9 && cur + 1 <= n {
                cur += 1;
            } else {
                cur /= 10;
                while cur % 10 == 9 {
                    cur /= 10;
                }
                cur += 1;
            }
        }
        result
    }
}