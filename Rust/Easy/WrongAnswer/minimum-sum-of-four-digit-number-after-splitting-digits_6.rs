impl Solution {
    pub fn minimum_sum(num: i32) -> i32 {
        
        let mut sum = num;
        for i in 0..4 {
            let mut new1 = 0;
            let mut new2 = 0;
            for j in 0..4 {
                if j < i {
                    new1 = new1 * 10 + num / 10i32.pow(j as u32) % 10;
                } else {
                    new2 = new2 * 10 + num / 10i32.pow(j as u32) % 10;
                }
            }
            sum = std::cmp::min(sum, new1 + new2);
        }
        sum
    }
}