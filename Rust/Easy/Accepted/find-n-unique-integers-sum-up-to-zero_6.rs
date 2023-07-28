impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        
        let mut ret = Vec::new();
        for i in 0..n/2 {
            ret.push(i+1);
            ret.push(-i-1);
        }
        if n%2 == 1 {
            ret.push(0);
        }
        ret
    }
}