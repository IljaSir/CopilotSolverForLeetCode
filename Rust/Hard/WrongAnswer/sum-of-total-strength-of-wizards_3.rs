impl Solution {
    pub fn total_strength(strength: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut sum = 0;
        let mut result = 0;
        let mut min = std::i32::MAX;
        for i in 0..strength.len() {
            while let Some(&x) = stack.last() {
                if strength[x] <= strength[i] {
                    break;
                }
                stack.pop();
                sum -= strength[x];
                min = std::cmp::min(min, strength[x]);
            }
            stack.push(i);
            sum += strength[i];
            min = std::cmp::min(min, strength[i]);
            result += min * sum;
            result %= 1000000007;
        }
        result
    }
}