impl Solution {
    pub fn total_strength(strength: Vec<i32>) -> i32 {
        
        let mut stack: Vec<(i32, i32)> = vec![];
        let mut ans = 0;
        for i in 0..strength.len() {
            let mut sum = strength[i];
            while let Some((_, x)) = stack.last() {
                if x > &strength[i] {
                    break;
                }
                stack.pop();
                sum += x;
            }
            ans = (ans + sum * strength[i]) % 1000000007;
            stack.push((i as i32, strength[i]));
        }
        ans
    }
}