impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 1..target.len() {
            ans += target[i-1].max(target[i] - target[i-1]);
        }
        ans += target[target.len()-1];
        ans
    }
}