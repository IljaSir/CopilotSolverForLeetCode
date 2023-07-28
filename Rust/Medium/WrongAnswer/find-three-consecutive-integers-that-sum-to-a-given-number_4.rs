impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut x = num - 6;
        if x % 3 == 0 {
            x /= 3;
            vec!(x, x + 1, x + 2)
        } else {
            vec!()
        }
    }
}