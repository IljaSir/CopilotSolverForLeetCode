impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut max = 0;
        for i in 0..customers.len() - minutes as usize + 1 {
            let mut temp = 0;
            for j in 0..customers.len() {
                if j < i || j >= i + minutes as usize {
                    if grumpy[j] == 0 {
                        temp += customers[j];
                    }
                } else {
                    temp += customers[j];
                }
            }
            if temp > max {
                max = temp;
            }
        }
        max
    }
}