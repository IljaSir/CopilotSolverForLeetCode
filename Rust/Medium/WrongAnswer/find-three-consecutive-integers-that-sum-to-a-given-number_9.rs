impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut ans = Vec::new();
        for i in 0..=num {
            let k = num - i;
            if i * (i + 1) == k * (k + 1) {
                ans.push(i);
                ans.push(i + 1);
                ans.push(i + 2);
                break;
            }
        }
        ans
    }
}