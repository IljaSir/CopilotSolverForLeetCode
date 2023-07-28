impl Solution {
    pub fn lexical_order(n: i32) -> Vec<i32> {
        

        let mut result: Vec<i32> = Vec::new();
        let mut i = 1;
        for _ in 0..n {
            result.push(i);
            if i * 10 <= n {
                i *= 10;
            } else if i % 10 != 9 && i + 1 <= n {
                i += 1;
            } else {
                while (i / 10) % 10 == 9 {
                    i /= 10;
                }
                i = i / 10 + 1;
            }
        }
        result
    }
}