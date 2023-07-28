impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; temperatures.len()];
        let mut stack = vec![];
        for (i, t) in temperatures.iter().enumerate() {
            while let Some((j, t1)) = stack.last() {
                if *t1 >= *t {
                    break;
                }
                ans[*j] = (i - *j) as i32;
                stack.pop();
            }
            stack.push((i, *t));
        }
        ans
    }
}