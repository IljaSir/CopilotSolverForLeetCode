impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut satisfied = 0;
        let mut max = 0;
        let mut temp = 0;
        let minutes = minutes as usize;
        for i in 0..customers.len() {
            if grumpy[i] == 0 {
                satisfied += customers[i];
            } else {
                temp += customers[i];
                if i >= minutes {
                    temp -= customers[i - minutes] * grumpy[i - minutes];
                }
                if temp > max {
                    max = temp;
                }
            }
        }
        satisfied + max
    }
}