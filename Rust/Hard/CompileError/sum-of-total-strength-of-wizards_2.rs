impl Solution {
    pub fn total_strength(strength: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut ans = 0;
        let mut sum = 0;
        for (i, &s) in strength.iter().enumerate() {
            sum += s;
            while !stack.is_empty() && stack.last().unwrap().0 >= s {
                let (t, j) = stack.pop().unwrap();
                ans = (ans + t * (sum - s * (i - j) as i32)) % 1000000007;
            }
            stack.push((s, i as i32));
        }
        while !stack.is_empty() {
            let (t, j) = stack.pop().unwrap();
            ans = (ans + t * (sum - t * (strength.len() as i32 - j))) % 1000000007;
        }
        ans
    }
}