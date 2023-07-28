impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut arr = arr;
        arr.push(0);
        let mut stack = Vec::new();
        for i in 0..arr.len() {
            while !stack.is_empty() && arr[stack[stack.len() - 1]] < arr[i] {
                let j = stack.pop().unwrap();
                let mut k = 1;
                while !stack.is_empty() && arr[stack[stack.len() - 1]] == arr[j] {
                    k += dp[stack.pop().unwrap()];
                }
                dp[j] = k;
            }
            stack.push(i);
        }
        let mut ans = 0;
        for i in 0..arr.len() - 1 {
            let mut k = 1;
            let mut j = i as i32 - 1;
            while j >= 0 && j >= i as i32 - d && arr[j as usize] < arr[i] {
                k += dp[j as usize];
                j -= 1;
            }
            j = i as i32 + 1;
            while j < arr.len() as i32 && j <= i as i32 + d && arr[j as usize] < arr[i] {
                k += dp[j as usize];
                j += 1;
            }
            ans = ans.max(k);
        }
        ans
    }
}