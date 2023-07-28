impl Solution {
    pub fn lexical_order(n: i32) -> Vec<i32> {
        

        let mut result = Vec::new();
        let mut current = 1;
        for _ in 0..n {
            result.push(current);
            if current * 10 <= n {
                current *= 10;
            } else if current % 10 != 9 && current + 1 <= n {
                current += 1;
            } else {
                while (current / 10) % 10 == 9 {
                    current /= 10;
                }
                current = current / 10 + 1;
            }
        }
        result
    }
}