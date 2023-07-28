impl Solution {
    pub fn count_bits(n: i32) -> Vec<i32> {
        
        let mut ret = vec![0; (n + 1) as usize];
        for i in 1..=n {
            ret[i as usize] = ret[(i & (i - 1)) as usize] + 1;
        }
        ret
    }
}