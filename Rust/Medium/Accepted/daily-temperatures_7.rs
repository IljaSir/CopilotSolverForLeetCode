impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut ans = vec![0; temperatures.len()];
        for i in 0..temperatures.len() {
            while let Some(&j) = stack.last() {
                if temperatures[j as usize] < temperatures[i] {
                    ans[j as usize] = (i as i32) - j;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i as i32);
        }
        ans
    }
}