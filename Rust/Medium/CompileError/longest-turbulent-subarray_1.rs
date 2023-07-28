impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let (mut ans, mut anchor) = (1, 0);
        for i in 1..arr.len() {
            let c = (arr[i - 1] - arr[i]).signum();
            if i == arr.len() - 1 || c * (arr[i] - arr[i + 1]).signum() != -1 {
                if c != 0 { ans = ans.max(i - anchor + 1); }
                anchor = i;
            }
        }
        ans
    }
}