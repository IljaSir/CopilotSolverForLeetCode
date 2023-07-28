impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; temperatures.len()];
        let mut stack = Vec::new();
        for (i, &t) in temperatures.iter().enumerate() {
            while let Some(&j) = stack.last() {
                if temperatures[j] < t {
                    ans[j] = (i - j) as i32;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        ans
    }
}