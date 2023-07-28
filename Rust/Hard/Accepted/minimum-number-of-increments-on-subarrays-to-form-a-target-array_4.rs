impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        
        let mut prev = 0;
        let mut ret = 0;
        for i in target {
            if i > prev {
                ret += i - prev;
            }
            prev = i;
        }
        ret
    }
}