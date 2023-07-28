impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut next = vec![vec![-1; 2]; n];
        let mut stack = vec![];
        let mut res = 0;
        for i in (0..n).rev() {
            while !stack.is_empty() && arr[stack[stack.len() - 1]] <= arr[i] {
                next[stack.pop().unwrap()][0] = i as i32;
            }
            while !stack.is_empty() && arr[stack[stack.len() - 1]] >= arr[i] {
                next[stack.pop().unwrap()][1] = i as i32;
            }
            stack.push(i);
        }
        let mut dp = vec![vec![false; 2]; n];
        dp[n - 1] = vec![true; 2];
        for i in (0..n - 1).rev() {
            for j in 0..2 {
                let ni = next[i][j] as usize;
                if ni < n {
                    dp[i][j] = dp[ni][1 - j];
                }
            }
            if dp[i][0] {
                res += 1;
            }
        }
        res + 1
    }
}