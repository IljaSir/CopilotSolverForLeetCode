impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut stack = vec![];
        let mut ans = vec![0; temperatures.len()];
        for i in 0..temperatures.len() {
            while let Some((j, t)) = stack.last() {
                if temperatures[*j] < temperatures[i] {
                    ans[*j] = (i - j) as i32;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push((i, temperatures[i]));
        }
        ans
    }
}