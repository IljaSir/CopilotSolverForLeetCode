impl Solution {
    pub fn count_operations(num1: i32, num2: i32) -> i32 {
        
        let mut n1 = num1;
        let mut n2 = num2;
        let mut count = 0;
        
        while n1 != 0 && n2 != 0 {
            if n1 > n2 {
                let tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            let mut tmp = n2 / n1;
            count += tmp;
            n2 -= n1 * tmp;
        }
        count
    }
}